import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
      PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
      for(int i = -3; i < 10; i++)
      {
        System.out.println("I: " + i + " | Pg: " + helper.pageIndex(i));
      }

      System.out.println(GenerateTableRow.make("Pagination", "solutionUrl", "https://www.codewars.com/kata/515bb423de843ea99400000a/train/java"));

    }
}
