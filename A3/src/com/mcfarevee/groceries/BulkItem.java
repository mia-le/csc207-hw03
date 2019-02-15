package com.mcfarevee.groceries;

public class BulkItem implements Item {

  // public fields
  public BulkFood food;
  public Unit unit;
  public int amount;

  // constructor
  public BulkItem(BulkFood food, Unit unit, int amount) {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  }

  // methods
  public Weight getWeight() {
    Weight weight = new Weight(this.unit, this.amount);
    return weight;
  }

  public int getPrice() {
    return this.food.pricePerUnit * this.amount;
  }

  public String toString() {
    if (this.amount < 2) {
      return (this.amount + " " + this.unit.name + " of " + this.food.name);
    } else {
      return (this.amount + " " + this.unit.plural + " of " + this.food.name);
    }
  }

  public boolean equals(BulkItem other) {
    // food.name
    if ((this.food.name.equals(other.food.name)) &&
    // food.unit
        (this.food.unit.name.equals(other.food.unit.name))
        && (this.food.unit.abbrev.equals(other.food.unit.abbrev))
        && (this.food.unit.plural.equals(other.food.unit.plural)) &&
        // food.pricePerUnit
        (this.food.pricePerUnit == other.food.pricePerUnit) &&
        // food.supply
        (this.food.supply == other.food.supply) &&
        // unit
        (this.unit.name.equals(other.unit.name)))
      return true;
    else {
      return false;
    }
  }
}
