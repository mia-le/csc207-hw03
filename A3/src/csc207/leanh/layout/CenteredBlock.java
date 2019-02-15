package csc207.leanh.layout;

import java.io.PrintWriter;

public class CenteredBlock implements TextBlock{
  int height;
  int width;
  TextBlock tb;
  
  
  public CenteredBlock(TextBlock tb, int width) throws Exception {
    this.height = tb.height();
    this.width = width;
    this.tb = tb;
    if (width < this.tb.width())
      throw new Exception ("Invalid width " + width);
  } // CenteredBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i) throws Exception{  
    if (this.tb.width() > this.width)
      throw new Exception ("Width of text exceeds width of block");
    String space = "";
    int numSpaces = (this.width - this.tb.width()) / 2;
    for (int o = 0; o < numSpaces; o++) {
      space = space + " ";
    }
    return space + this.tb.row(i) + space;
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
 /* TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock block2 = new BoxedBlock(new CenteredBlock(block, 11));
    TBUtils.print(pen, block2);
 *//*
    TextBlock top = new CenteredBlock(new TextLine("Hello"), 4);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 4);
    TextBlock block = new BoxedBlock(new VComposition(top,bottom));
    TBUtils.print(pen, block);
    */
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    pen.println("Bottom width: " + compound.width());
    tb2.setContents("Someone");
    pen.println("UPDATED");
    pen.println("Bottom width: " + compound.width());
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
    pen.println("Bottom width: " + compound.width());
  }
} // class CenteredBlock