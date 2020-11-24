import java.util.ArrayDeque;
import java.util.Deque;

public class FactorialCalc {
  public static String Factorial(int n) {
    String num = "1";
    int overflow = 0;
    for(int i = 1; i <= n; i++)
    {
      char[] digits = num.toCharArray();
      Deque<Character> stack = new ArrayDeque<Character>();
      for(int j = digits.length - 1; j >= 0; j --)
      {
        final int mult = Character.getNumericValue(digits[j]) * i + overflow;
        stack.push( Character.forDigit(mult,10) );
        overflow = mult / 10;
      }
      stack.push(Character.forDigit(overflow,10));

      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty())
      {
        sb.append(stack.pop());
      }
      num = sb.toString();
    }
    return num;
  }
}
