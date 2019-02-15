package csc207.leanh.layout;

import java.io.PrintWriter;

public class RightJustified implements TextBlock{
  int height;
  int width;
  TextBlock tb;

  
  public RightJustified(TextBlock tb, int width) throws Exception {
    this.height = tb.height();
    this.width = width;
    this.tb = tb;
    if (width < this.tb.width())
      throw new Exception ("Invalid width " + width);
  } // RightJustified(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i) throws Exception{  
    if (this.tb.width() > this.width)
      throw new Exception ("Width of text exceeds width of block");
    String space = "";
    int numSpaces = this.width - this.tb.width();
    for (int o = 0; o < numSpaces; o++) {
      space = space + " ";
    }
    return space + this.tb.row(i);
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
  } // width()
  
  public static void main (String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
 /*   TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new BoxedBlock(new RightJustified(block, 11));
    TBUtils.print(pen, block2);
    */
    TextBlock top = new RightJustified(new TextLine("Hello"), 15);
    TextBlock bottom = new RightJustified(new TextLine("Goodbye"), 15);
    TextBlock block = new BoxedBlock(new VComposition(top,bottom));
    TBUtils.print(pen, block);
  }
} // class RightJustified