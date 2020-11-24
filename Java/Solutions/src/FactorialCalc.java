import java.util.ArrayDeque;
import java.util.Deque;

public class FactorialCalc {
  public static String Factorial(int n) {
    String num = "1";
    for(int i = 1; i <= n; i++)
    {
      int overflow = 0;
      char[] digits = num.toCharArray();
      Deque<Character> stack = new ArrayDeque<Character>();
      for(int j = digits.length - 1; j >= 0; j --)
      {
        final int mult = Character.getNumericValue(digits[j]) * i + overflow;
        stack.push( Character.forDigit(mult % 10,10) );
        overflow = mult / 10;
        if(i == 15)
          System.out.println("Break");

      }  

      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty())
      {
        sb.append(stack.pop());
      }
      num = (overflow == 0 ? "" : Integer.toString(overflow)) + sb.toString();
      System.out.println("Fac(" + i + "): " + num);
    }
    return num;
  }
}
