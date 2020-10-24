
public class Interval {

    public static int sumIntervals(int[][] intervals) {
      if(intervals == null) return 0;
      
      int start = Integer.MAX_VALUE;
      int end = Integer.MIN_VALUE;
      int total = 0;
      
      for(int[] interval : intervals)
      {
        if(interval[0] < start ) start = interval[0];
        else if(interval[0] > end)
        {
          total += end - start;
          start = interval[0];
        }

        if(interval[1] > end) end = interval[1];
      }
      total += end - start;
      return total;
    }
}
