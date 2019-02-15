package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.Arrays;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Weight;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.NonFood;



public class Cart {

  Item[] items = new Item[3];
  public static int entries = 0;
  public static int things = 0;

  public void addItem(Item item) {
    //array expand when out of space
    if (this.entries == this.items.length) {
      int newSize = 2 * this.items.length;
      this.items = Arrays.copyOf(this.items, newSize);
    }
    //if its a ManyPackages then add count
    if (item instanceof ManyPackages) {
      things = things + ((ManyPackages) item).getCount();
      ///if not add one to 'things' counter
    } else {
      things++;
    }
    //add item to cart
    this.items[entries] = item;
    this.entries++;
  }

  public int numEntries() {
    return this.entries;
  }

  public int numThings() {
    return this.things;
  }

  public void printContents(PrintWriter pen) {
    for (int i = 0; i < this.entries; i++) {
      pen.println(items[i].toString());
    }
  }

  public int getPrice() {
    int price = 0;
    for (int i = 0; i < this.entries; i++) {
      price += items[i].getPrice();
    }
    return price;
  }
 


  public Weight[] getWeight() {
    // counters for each type
    int ounces = 0;
    int pounds = 0;
    int grams = 0;
    int kilograms = 0;
    // add to each type
    for (int i = 0; i < this.entries; i++) {
      Weight current = items[i].getWeight();
      if (current.unit.name.equals("ounce")) {
        ounces += current.amount;
      } else if (current.unit.name.equals("pound")) {
        pounds += current.amount;
      } else if (current.unit.name.equals("gram")) {
        grams += current.amount;
      } else if (current.unit.name.equals("kilogram")) {
        kilograms += current.amount;
      }
    }
    // create Weight objects for each type
    Weight oz = new Weight(Unit.OUNCE, ounces);
    Weight lbs = new Weight(Unit.POUND, pounds);
    Weight g = new Weight(Unit.GRAM, grams);
    Weight kg = new Weight(Unit.KILOGRAM, kilograms);
    // put objects into a array
    Weight[] totalWeightVals = {oz, lbs, g, kg};
    return totalWeightVals;
  }

  public void remove(String name) {
    for (int u = 0; u < this.entries; u++) {
      if ((items[u] instanceof ManyPackages) && ((ManyPackages) items[u]).type.name.equals(name)){
       items[u] = items[this.entries - 1];
       this.entries--;
      }
      if ((items[u] instanceof Package) && ((Package) items[u]).name.equals(name)){
        items[u] = items[this.entries - 1];
        this.entries--;
       }
      if ((items[u] instanceof BulkItem) && ((BulkItem) items[u]).food.name.equals(name)){
        items[u] = items[this.entries - 1];
        this.entries--;
       }
      if ((items[u] instanceof NonFood) && ((NonFood) items[u]).name.equals(name)){
        items[u] = items[this.entries - 1];
        this.entries--;
       }
          
    }
    
  }

  public void merge() {
for (int i = 0; i < this.entries; i++) {
  PrintWriter pen = new PrintWriter(System.out, true);
  
  pen.println("i: " + i + " " +items[i].toString());
  
  for (int u = i+1; u < this.entries; u++) {
    pen.println("u: " + u + " "+ items[u].toString());
    /*
    if(this.items[i].equals(this.items[u])) {

      pen.println("Equal");
      */
      //add 2 Packages to make 1 ManyPackages
      if ((this.items[i] instanceof Package) && (this.items[u] instanceof Package) 
          && (((Package)items[i]).equals(((Package)items[u])))){
        ManyPackages newManyPackages= new ManyPackages((Package)this.items[i], 2);
        this.items[i] = newManyPackages;
        this.items[u] = items[this.entries - 1];
        this.entries--;
       }
      
      //add 1 Package to a ManyPackages
      if ((items[i] instanceof Package) && (items[u] instanceof ManyPackages)
          && (((Package)items[i]).equals(((ManyPackages)items[u]).type))){
        int newCount = ((ManyPackages) items[u]).count + 1;
       items[i] = new ManyPackages((Package)items[i], newCount);
       items[u] = items[this.entries - 1];
        this.entries--;
       }
      
      //add a ManyPackages to a Package
      if ((items[u] instanceof Package) && (items[i] instanceof ManyPackages)
          && (((Package)items[u]).equals(((ManyPackages)items[i]).type))){
        int newCount = ((ManyPackages) items[i]).count + 1;
       items[u] = new ManyPackages((Package)items[u], newCount);
       items[i] = items[this.entries - 1];
        this.entries--;
       }

//add a ManyPackages to a ManyPackages
      if ((items[i] instanceof ManyPackages) && (this.items[u] instanceof ManyPackages)){
        items[i] = new ManyPackages(((ManyPackages) items[i]).type,((ManyPackages) items[i]).count + ((ManyPackages) items[u]).count);
       items[u] = items[this.entries - 1];
        this.entries--;
       }

      //add 2 BulkItems
      if ((this.items[i] instanceof BulkItem) && (this.items[u] instanceof BulkItem) 
          && (((BulkItem)items[i]).equals(((BulkItem)items[u])))){
        BulkItem newBulkItem = new BulkItem(((BulkItem)items[i]).food, 
            ((BulkItem)items[i]).unit, 
            ((BulkItem)items[i]).amount + ((BulkItem)items[u]).amount);
        this.items[i] = newBulkItem;
        this.items[u] = items[this.entries - 1];
        this.entries--;
       }
    }
    
    
  }
}

  }
  

