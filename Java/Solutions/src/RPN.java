import java.util.*;
class RPN {

  public static double evaluate(String expr) {
    double a;
    double b; 
    final char[] chars = expr.toCharArray();
    final int op = "+-*/".indexOf(chars[chars.length - 1]);//0:add 1:subtr 2:multipy 3:div -1:none
    int lastSpace = expr.lastIndexOf(" ");

    if(lastSpace == -1)//just parse
      return Double.parseDouble(expr);
    else//evaluate
    {
      String strA = expr.substring(lastSpace + 1);
      String strB = expr.substring(0,lastSpace);
      
      if(op == -1)
      {
        a = evaluate(strA);
        b = evaluate(strB);
        return a > b ? a : b;
      }
      else
      {
        lastSpace = expr.substring(0,lastSpace).indexOf(" ");//should never be -1
        a = evaluate(strB.substring(lastSpace + 1));
        b = evaluate(strB.substring(0,lastSpace));

        Hashtable<Integer,Double> opHash = new Hashtable<Integer,Double>();
        opHash.put(0,a+b);
        opHash.put(1,a-b);
        opHash.put(2,a*b);
        opHash.put(3,a/b);

        return opHash.get(op);
      }
    }
  }
}

//"20 5 +"