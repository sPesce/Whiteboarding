public class Hamming {

	public static long hamming(int n) {
    if( n <= 6) return (long)n;

    int currentN = 7;
    long currentHam = 7;
    
    while(currentN <= n)
    {
      if(isHam(currentHam))      
        currentN++;
      
      currentHam++;      
    }
    return currentHam - 1;
  }
  private static boolean isHam(long x) {
    long reduced = x;
    int[] factors = {5,3,2};
    for(int factor : factors)
    {
      while(reduced % factor == 0)
        reduced /= factor;
    }
    return reduced == 1;    
  } 
}