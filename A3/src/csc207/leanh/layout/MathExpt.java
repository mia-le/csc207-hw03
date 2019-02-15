package csc207.leanh.layout;

import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * A few simple experiments with our utilities.
 * Version 1.1 of February 2019.
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    for (int i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for 
    
    Integer a = 3;
    double roota = MathUtils.squareRoot(a);
    pen.println("The square root of Int" + a + " seems to be " + roota);
    pen.println(roota + "^2 = " + (roota * roota));
    
    Float b = 3.56f;
    double rootb = MathUtils.squareRoot(b);
    pen.println("The square root of Int" + b + " seems to be " + rootb);
    pen.println(rootb + "^2 = " + (rootb * rootb));
    
    BigDecimal c = new BigDecimal(1115.37);
    double rootc = MathUtils.squareRoot(c);
    pen.println("The square root of Int" + c + " seems to be " + rootc);
    pen.println(rootc + "^2 = " + (rootc * rootc));
    
    double d = 3.56;
    double rootd = MathUtils.squareRoot(d);
    pen.println("The square root of Int" + d + " seems to be " + rootd);
    pen.println(rootd + "^2 = " + (rootd * rootd));

    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
