import java.util.*;
class ArrToRange {
  //rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
  // returns "-6,-3-1,3-5,7-11,14,15,17-20"
  public static String rangeExtraction(int[] arr) {
    List<String> ranges = new LinkedList<>();
    int start = arr[0];
    int end;
    boolean isRange = true;
    
    for(int i = 1; i < arr.length ; i++)
    {
      if (arr[i] == (arr[i-1] + 1))
      {
        end = arr[i];
      }

      //next consecutive ? find end : print just number
      //next consecutive & have end ? print start-absVal(end)
    }
    System.out.println();
    return "";
  }
}