import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
      PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
      for(int i = 0; i < 6; i++)
      {
        System.out.println("I: " + i + " | Pg: " + helper.pageIndex(i));
      }

    }
}
