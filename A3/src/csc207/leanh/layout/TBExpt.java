package csc207.leanh.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");

    // Print out the block
    TBUtils.print(pen, block);
    
    TextBlock block1 = new TextLine("This is a test.");
    TBUtils.print(pen,block1);
    
    BoxedBlock box = new BoxedBlock(block);
    TBUtils.print(pen,box);
    
    HComposition boxbox = new HComposition(block,block1);
    TBUtils.print(pen,boxbox);
    
    TextBlock block2 = new TextLine("      ");
    
    BoxedBlock boxEmpty = new BoxedBlock(boxbox);
    TBUtils.print(pen,boxEmpty);
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
