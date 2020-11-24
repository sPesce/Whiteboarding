public class FactorialCalc {
  public static String Factorial(int n) {
    if(n == 1) return "1";

    return multiply(n, Factorial(n-1));
  }
  private static String multiply(int x, String num)
  {      
    int overflow = 0;
    char[] digits = num.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int j = digits.length - 1; j >= 0; j --)
    {
      final int mult = Character.getNumericValue(digits[j]) * x + overflow;
      sb.append( Character.forDigit(mult % 10,10) );
      overflow = mult / 10;
    }  
      
    //overflow added to the front if it exists
    return (overflow == 0 ? "" : Integer.toString(overflow)) + sb.reverse().toString();
  }
}
