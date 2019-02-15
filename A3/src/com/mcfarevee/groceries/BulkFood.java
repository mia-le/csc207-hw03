package com.mcfarevee.groceries;

public class BulkFood {
  
  // fields
  public String name;
  public Unit unit;
  public int pricePerUnit;
  public int supply;
  
  // constructor
  public BulkFood(String name, Unit unit, int price, int supply) {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = price;
    this.supply = supply;
  } 
 }
