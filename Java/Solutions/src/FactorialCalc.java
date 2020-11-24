public class FactorialCalc {
  public static String Factorial(int n) {
    String num = "1";
    for(int i = 1; i <= n; i++)
    {
      int overflow = 0;
      char[] digits = num.toCharArray();
      StringBuilder sb = new StringBuilder();
      for(int j = digits.length - 1; j >= 0; j --)
      {
        final int mult = Character.getNumericValue(digits[j]) * i + overflow;
        sb.append( Character.forDigit(mult % 10,10) );
        overflow = mult / 10;
      }  
       
      //overflow added to the front if it exists
      num = (overflow == 0 ? "" : Integer.toString(overflow)) + sb.reverse().toString();
    }
    return num;
  }
}
