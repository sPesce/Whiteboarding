public class FactorialCalc {
  public static String Factorial(int n) {
    return Integer.toString(factorial(n));
  }
  private static int factorial(int n){
    if( n == 1)
      return 1;
    return n * factorial(n-1);
  }
}
