import java.util.*;
class RPN {

  public static double evaluate(String expr) {
    
    int start = 0;
    int space = expr.indexOf(' ');
    
    Deque<Double> stack = new ArrayDeque<Double>();
    
    // do
    // {
    //   int end = space == -1 ? expr.length() : space;
    //   String current = expr.substring(start,end);
    //   if("+-*/".indexOf(current) != -1)//check if current is operator
    //   {
    //     Double a = stack.pop();
    //     Double b = stack.pop();
    //     stack.push(operate(current.charAt(0),a,b)); 
    //   }     
    //   else
    //   {
    //     stack.add(Double.parseDouble(current));
    //   }
    //   start = end + 1;
    //   System.out.println(expr.substring(start).indexOf(' '));
    //   space = expr.substring(start).indexOf(' ');
    // }while(start < expr.length());
    int end = space == -1 ? expr.length() : space;
    System.out.println("start: " + start);
    System.out.println("end: " + end);
    System.out.println("curr: " + expr.substring(start,end));
    
    return 0;   
  }
  //return a <operand> b
  public static double operate(char operand,double a, double b){
    
    Hashtable<Character,Double> opHash = new Hashtable<Character,Double>();
    opHash.put('+',a+b);
    opHash.put('-',a-b);
    opHash.put('*',a*b);
    opHash.put('/',a/b);

    return opHash.get(operand);
  }
}

//"20 5 +"