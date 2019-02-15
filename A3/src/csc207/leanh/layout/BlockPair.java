package csc207.leanh.layout;

import java.io.PrintWriter;

public class BlockPair implements TextBlock{
  int height;
  int width;
  TextBlock tb;
  
  
  public BlockPair(TextBlock tb) {
    this.height = tb.height();
    this.width = this.width * 2;
    this.tb = tb;

  } // BlockPair(TextBlock)

  /**
   * Get the ith row of the block.
   */
  public String row(int i) throws Exception{  

    return this.tb.row(i) + this.tb.row(i);
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  } //... width()
  
  public static void main (String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    TextBlock block = new TextLine("Hello");
    TextBlock pair = new BlockPair(block);
    TBUtils.print(pen, pair);
  }
} // class TruncatedBlock