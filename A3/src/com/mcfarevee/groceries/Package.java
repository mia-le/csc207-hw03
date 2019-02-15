package com.mcfarevee.groceries;

import java.lang.String;

public class Package implements Item {

  public String name;
  public Weight weight;
  public int price;

  public Package(String name, Weight weight, int price) {
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
    if (this.getWeight().amount < 2) {
      return this.getWeight().amount + " " + this.getWeight().unit.name + " package of "
          + this.name;
    } else {
      return this.getWeight().amount + " " + this.getWeight().unit.plural + " package of "
          + this.name;
    }
  }

  public boolean equals(Package other) {
    // name
    if ((this.name.equals(other.name)) &&
    // weight
        (this.weight.unit.name.equals(other.weight.unit.name))
        && (this.weight.unit.abbrev.equals(other.weight.unit.abbrev))
        && (this.weight.unit.plural.equals(other.weight.unit.plural))
        && (this.weight.amount == other.weight.amount) &&
        // price
        (this.price == other.price)) {
      return true;
    } else {
      return false;
    }
  }
}
