package csc207.leanh.layout;

import java.io.PrintWriter;

public class TruncatedBlock implements TextBlock{
  int height;
  int width;
  TextBlock tb;
  
  /**
   * Create a new truncated block of the specified width.
   */
  public TruncatedBlock(TextBlock tb, int width) {
    this.height = tb.height();
    this.width = width;
    this.tb = tb;
  } // TruncatedBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i) throws Exception{  
   return (tb.row(i)).substring(0, this.width);
  } // row(int)

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
  
  public static void main (String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new TruncatedBlock(block, 3);
    TBUtils.print(pen, block);
    TBUtils.print(pen, block2);
  }
} // class TruncatedBlock

