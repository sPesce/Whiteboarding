import java.util.List;
import java.util.LinkedList;
class ArrToRange {
  //rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
  // returns "-6,-3-1,3-5,7-11,14,15,17-20"
  public static String rangeExtraction(int[] arr) {
    List<String> ranges = new LinkedList<>();
    
    int start;
    int end;
    start = end = arr[0];
    
    for(int i = 1; i < arr.length ; i++)
    {
      if (arr[i] == (arr[i-1] + 1) )//is consecutive from previous el
      {
        end = arr[i];
      }
      if( arr[i] != (arr[i-1] + 1) || i == arr.length - 1)
      {
        String startStr = Integer.toString(start);
        
        if(start == end)
          ranges.add( startStr);
        else
        {
          String endStr = Integer.toString( end );

          ranges.add(startStr + "-" + endStr);
        }
        start = end = arr[i];
      }

      //next consecutive ? find end : print just number
      //next consecutive & have end ? print start-absVal(end)
    }
    return String.join(",",ranges);
  }
}