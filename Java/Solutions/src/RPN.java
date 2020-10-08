import java.util.*;
class RPN {

  public static double evaluate(String expr) {
    double a;
    double b;
    final char[] chars = expr.toCharArray();
    final int op = "+-*/".indexOf(chars[chars.length - 1]);//0:add 1:subtr 2:multipy 3:div -1:none
    final int lastSpace = expr.lastIndexOf(" ");

    if(lastSpace == -1)//just parse
      return Double.parseDouble(expr);
    else//evaluate
    {
      String aStr = expr.substring(lastSpace + 1);
      a = Double.parseDouble(aStr);
      b = evaluate(expr.substring(0,lastSpace));

      if(op == -1)
      {
        return a > b ? a : b;
      }
      else
      {
        Hashtable<Integer,Double> opHash = new Hashtable<Integer,Double>();
        opHash.put(0,a+b);
        opHash.put(1,a-b);
        opHash.put(2,a*b);
        opHash.put(3,a/b);

      }
    }
    
    
    //ends with operator?
    //contains 2 operands?
    //evaluate last operator
    //recursive first operator



    return 0;
  }
}