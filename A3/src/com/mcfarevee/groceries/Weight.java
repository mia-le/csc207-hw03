package com.mcfarevee.groceries;

public class Weight {
  public Unit unit;
  public int amount;
  
  public Weight(Unit measure, int measureQuant){
    this.unit = measure;
    this.amount = measureQuant;
  }
}
