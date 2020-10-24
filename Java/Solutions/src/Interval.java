

import java.util.Arrays;
import java.util.LinkedList;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
      if( intervals == null || intervals.length == 0 ) return 0;
      print2dArr(intervals);
      
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
          if(values[j] == null)
          {
            System.out.println("\tvalues[" + j +"] is null, setting to: " + a + "," + b);
            values[j] = new int[] {a,b};
            break;
          }
          else if( inRange(a, values[j]) && inRange(b,values[j]))
            break;
          //there is an overlap PAST values[j]
          else if( inRange(a,values[j]) && b > values[j][1]){
            System.out.println("\t[" + values[j][0] + "," + values[j][1] + "] ... b <=== " + b);
            values[j][1] = b;
            break;
          }
          //there is an overlap BEFORE values[j]
          else if( inRange(b,values[j]) && a < values[j][0]){
            System.out.println("\t[" + values[j][0] + "," + values[j][1] + "] ... a <=== " + a);
            values[j][0] = a;
            break;
          }
        }
        print2dArr(values,"Printing values"); 
      }
      boolean overlap = false;
      int sum = 0;
      for(int i = 0 ; i <= jMax ; i++)
      {
        int a = values[i][0];
        int b = values[i][1];
        sum += (b - a);
        for(int j = 0; j <= jMax ; j++)
        {
          int[] other = values[j];
          if(inRange(a,other,true) || inRange(b,other,true))
            overlap = true;
        } 
      }
      if(overlap) 
      {
        int[][] trimmed = Arrays.copyOfRange(values,0,jMax + 1);
        return sumIntervals(trimmed);
      }
      return sum; 
    }

    public static boolean inRange(int x, int[] a2d, boolean strictly) {
      if (strictly)
        return (x > a2d[0] && x < a2d[1]);
      return  (x >= a2d[0] && x <= a2d[1]);
    }

    public static boolean inRange(int x, int[] a2d){return inRange(x,a2d,false);}

    public static void print2dArr(int[][] a2d,String label){
      System.out.println("----" + label + "----");
      for(int[] a1d: a2d)
      {
        if(a1d == null) break;
        System.out.print(" [" + a1d[0] + "," + a1d[1] + "] ");
      }
      System.out.println("\n--------------------");
    }
    public static void print2dArr(int[][] a2d) {print2dArr(a2d,"------------");}
}