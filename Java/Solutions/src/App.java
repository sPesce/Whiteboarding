import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

      System.out.println(Greed.greedy(new int[] {1,1,1,3,1}) );

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
