import java.util.Arrays;
public class MiddleIndex {
  public static int findEvenIndex(int[] arr) {    
    for(int i = 0; i < arr.length; i++)
    {
      if(equalSides(arr,i)) return i;     
    }
    return -1;
  }//do the sub arrays before and after index have equal sums?
  public static boolean equalSides(int[] array,int index)
  {
    int lastIdx = array.length - 1;
    int a = index == 0 ? 0 : subArraySum(array,0,index);
    int b = index == lastIdx ? 0 : subArraySum(array,index + 1,lastIdx + 1);

    return a == b; 
  }//what is the sum of array 'array' with starting index 'start', ending 'end - 1'
  public static int subArraySum(int[] array, int start, int end)
  {
    return Arrays.stream(Arrays.copyOfRange(array, start, end)).sum();
  }
}