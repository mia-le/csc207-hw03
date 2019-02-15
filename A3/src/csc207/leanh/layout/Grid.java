package csc207.leanh.layout;

import java.io.PrintWriter;

public class Grid implements TextBlock{

  int width;
  int height;
  char ch;
  
  public Grid(int width, int height, char ch) {
    this.width = width;
    this.height = height;
    this.ch = ch;
  }
  
  public int width() {
    return this.width;
  }
  
  public int height() {
    return this.height;
  }
  
  
  public String row(int i) throws Exception{
    
    String line = "";
    if (i < 0) 
      throw new Exception("Invalid row " + i);
    for(int x = 0; x < this.width; x++) {
      line = line + this.ch;     
    }
    return line;
  }
  
  public static void main (String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    TBUtils.print(pen, new BoxedBlock(new Grid(7, 3, '*'))); 
  }
}
