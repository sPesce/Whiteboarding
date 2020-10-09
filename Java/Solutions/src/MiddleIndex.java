public class MiddleIndex {
  public static int findEvenIndex(int[] arr) {
    
    for(int i = 0; i < arr.length; i++)
    {
      int a = 0;
      int b = 0;

      for(int j = 0; j < arr.length ; j++)
      {
        if(j < i)
          a+= arr[j];
        if(j > i)
          b+= arr[j];
      }
      if ( a == b ) return i;
    }
    return -1;
  }
}