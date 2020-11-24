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
      }  

      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty())      
        sb.append(stack.pop());
      //overflow added to the front if it exists
      num = (overflow == 0 ? "" : Integer.toString(overflow)) + sb.toString();
    }
    return num;
  }
}
