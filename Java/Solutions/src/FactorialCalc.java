public class FactorialCalc {
  public static String Factorial(int n) {
    if(n > 1) return multiply(n, Factorial(n-1));
    return "1";
  }
  private static String multiply(int x, String num)
  {      
    int overflow = 0;
    char[] digits = num.toCharArray();
    StringBuilder sb = new StringBuilder();
    
    //multiplication by hand approach
    for( int j = digits.length - 1; j >= 0; j-- )
    {
      //multiplication at current digit
      final int mult = Character.getNumericValue(digits[j]) * x + overflow;
      sb.append( Character.forDigit(mult % 10,10) );//append 1s place
      overflow = mult / 10;
    }        
    //overflow added to the front if it exists
    return (overflow == 0 ? "" : Integer.toString(overflow)) + sb.reverse().toString();
  }
}
