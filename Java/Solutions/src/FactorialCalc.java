public class FactorialCalc {
  public static String Factorial(int n) {
    //recursively call this method, which calls recursive multiply method
    if(n > 1) return multiply(n, Factorial(n-1),0,new StringBuilder());
    return "1";
  }
  //pops last digit, multiplies by x, adds it to string builder, sb to string on exit condition
  private static String multiply(int x, String num, int overflow, StringBuilder sb)
  {  //recursive exit cond. will return string from sb, add overflow if nonzero
    if(num.length() == 0)    
      return (overflow == 0 ? "" : Integer.toString(overflow)) + sb.reverse().toString();

    //add last digit * x to string builder
    final char digit = num.toCharArray()[num.length() - 1];
    final int product = Character.getNumericValue(digit) * x + overflow;
    sb.append(Character.forDigit(product % 10, 10));
    
    //num loses last char, overflow calculated from product
    return multiply(x, num.substring(0, num.length() - 1), product / 10 , sb);
  } 
}
