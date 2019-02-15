package com.mcfarevee.groceries;

public class NonFood implements Item {
  public String name;
  public Weight weight;
  public int price;

  public NonFood (String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }
  
  public Weight getWeight() {
    return this.weight;
  }


  public int getPrice() {
    return this.price;
  }

  public String toString() {
    return this.name;
  }
  
  public boolean equals(NonFood other) {
    // name
    if ((this.name.equals(other.name)) &&
    // weight
        (this.weight.unit.name.equals(other.weight.unit.name))
        && (this.weight.unit.abbrev.equals(other.weight.unit.abbrev))
        && (this.weight.unit.plural.equals(other.weight.unit.plural))
        && (this.weight.amount == other.weight.amount) &&
        //price
        (this.price == other.price)){
      return true;
    } else {
      return false;
    }
  }
}
