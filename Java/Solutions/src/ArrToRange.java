import java.util.List;
import java.util.LinkedList;
class ArrToRange {
  //rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
  // returns "-6,-3--1,3-5,7-11,14,15,17-20"
  public static String rangeExtraction(int[] arr) 
  {
    //holds each range segment
    List<String> ranges = new LinkedList<>();
    
    int start;//a of range from a-b
    int end;//b of range from a-b
    start = end = arr[0];
    
    for(int i = 1; i < arr.length ; i++)
    { 
      final boolean consecutive = arr[i] == (arr[i-1] + 1);
      if ( consecutive )
      {
        end = arr[i];//set new end every time its consecutive
      }
      //is not a consecutive num or is the last element
      if( !consecutive || i == arr.length - 1)
      {
        String startStr = Integer.toString(start);
        
        if(start == end)//is a single number, no range
          ranges.add( startStr);
        else
        {
          String endStr = Integer.toString( end );
          
          //if range = n -> n+1, ==> "n,n+1"
          //if range spans more than 2, ==> "n1-n2"
          char joiner = (end - start == 1) ? ',' : '-';

          ranges.add( startStr + joiner + endStr);
        }
        //always reset start/end if not consecutive number
        start = end = arr[i];
      }
    }
    return String.join(",",ranges);
  }
}
