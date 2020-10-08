import java.util.*;
class RPN {
  public static double evaluate(String expr) {
    if (expr.isEmpty()) return 0;
    
    int start = 0;
    
    Deque<Double> stack = new ArrayDeque<Double>();
    
    do
    {
      int space = expr.substring(start).indexOf(' ');
      int end = space == -1 ? expr.length() : start + space;
      String current = expr.substring(start,end);//current number or operator
      if("+-*/".indexOf(current.charAt(0)) != -1)//check if current is operator
      {//pop 2 and apply operation
        Double a = stack.pop();
        Double b = stack.pop();
        stack.push(operate(current.charAt(0),b,a)); 
      }     
      else
      {
        stack.push(Double.parseDouble(current));
      }
      start = end + 1;//start over at index after the space
    }while(start < expr.length());
    
    double result = stack.pop();
    
    while(!stack.isEmpty())//stack non-empty -> return greatest val
    {
      double current = stack.pop();
      result = current > result ? current : result;
    }

    return result;   
  }
  //return a <operand> b
  public static double operate(char operand,double a, double b){
    
    Hashtable<Character,Double> opHash = new Hashtable<Character,Double>();
    opHash.put('+',a + b);
    opHash.put('-',a - b);
    opHash.put('*',a * b);
    opHash.put('/',a / b);

    return opHash.get(operand);
  }
}