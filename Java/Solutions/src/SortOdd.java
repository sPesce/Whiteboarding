import java.util.Collections;
import java.util.LinkedList;

public class SortOdd {
  public static int[] sortArray(int[] array) {
    if (array == null || array.length == 0)
      return array;
    
    LinkedList<Integer> numList = new LinkedList<Integer>();
    for(int num : array)
    {
      if(num % 2 == 1)
        numList.push(num);
    }
    Collections.sort(numList);

    for(int i = 0; i < array.length ; i++)
    {
      if(array[i] % 2 == 1)
        array[i] = numList.pollFirst();
    }

    return array;
  }
}
