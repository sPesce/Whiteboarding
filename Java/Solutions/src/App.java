import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

      System.out.println("Returned: " + Interval.sumIntervals(new int[][]{{16,19},{10,20},{5,11},{1,6},{1,5}}));

    }





    //----------------------------------
    public static void testPagination() {
      PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
      for(int i = -3; i < 10; i++)
      {
        System.out.println("I: " + i + " | Pg: " + helper.pageIndex(i));
      }
    }
}
