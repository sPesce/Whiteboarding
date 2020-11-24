public class FactorialCalc {
  public static String Factorial(int n) {
    if(n > 1) return multiply(n, Factorial(n-1),0,new StringBuilder());
    return "1";
  }
  private static String multiply(int x, String num, int overflow, StringBuilder sb)
 {
    if(num.length() == 0)
      return (overflow == 0 ? "" : Integer.toString(overflow)) + sb.reverse().toString();
   
    char digit = num.toCharArray()[num.length() - 1];
    final int product = Character.getNumericValue(digit) * x + overflow;
    sb.append(Character.forDigit(product % 10, 10));

    return multiply(x, num.substring(0, num.length() - 1), product / 10 , sb);
 } 
}
