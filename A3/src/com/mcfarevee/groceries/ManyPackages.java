package com.mcfarevee.groceries;

public class ManyPackages implements Item {
  public Package type;
  public int count;
  
  public ManyPackages (Package type, int count) {
    this.type = type;
    this.count = count;
  }

  public Weight getWeight() {
    int total = this.count * this.type.getWeight().amount;
    Weight weight = new Weight(this.type.getWeight().unit, total);
    return weight;
  }


  public int getPrice() {

    return (this.count * this.type.getPrice());
  }

  public String toString() {
    return (this.count + "x" + this.type.toString());
  }
  
  public int getCount() {
    return this.count;
  }
  
  public boolean equals(ManyPackages other) {
    // type.name
    if ((this.type.name.equals(other.type.name)) &&
    // type.weight
        (this.type.weight.unit.name.equals(other.type.weight.unit.name))
        && (this.type.weight.unit.abbrev.equals(other.type.weight.unit.abbrev))
        && (this.type.weight.unit.plural.equals(other.type.weight.unit.plural))
        && (this.type.weight.amount == other.type.weight.amount) &&
        // type.price
        (this.type.price == other.type.price) &&
        //count
        (this.count == other.count)){
      return true;
    } else {
      return false;
    }
  }

}
