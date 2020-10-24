package cw;

import java.util.Arrays;
import java.util.LinkedList;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
      if( intervals == null || intervals.length == 0 ) return 0;
      
      int[][] values = new int[intervals.length][];
      
      int jMax = 0;

      for(int i = 0; i < intervals.length ; i++)
      {
        //a: start of interval, b: end of it
        final int a = intervals[i][0];
        final int b = intervals[i][1];
        System.out.println("Interval: [" + a + "," + b + "]" );
        for(int j = 0; j <= i ; j++)
        {
          jMax = Integer.max(jMax,j);
          //System.out.println("Values[" + j + "][0] = " + values[j][0]);
          //System.out.println("Values[" + j + "] length : " + values[j].length);
          System.out.println("Values: " + values[j]);
          if(values[j] == null)
          {
            System.out.println("Hit empty");
            System.out.println("Found empty values, setting " + a + "," + b);
            values[j] = new int[] {a,b};
            break;
          }
          //is a between values[j][0] and values[j][1]
          else if( a >= values[j][0] && a < values[j][1])
          {
            if( b > values[j][1]) values[j][1] = b;
            break;
          }
        } 
      }
      
      int sum = 0;
      for(int i = 0 ; i <= jMax ; i++)
      {
        System.out.println("Adding (" + values[i][1] + " - " + values[i][0] + ") to sum: " + sum);
        sum += (values[i][1] - values[i][0]); 
      }
      return sum; 
    }
}