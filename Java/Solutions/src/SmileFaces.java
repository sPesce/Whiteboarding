import java.util.*;
import java.util.regex.Pattern;

public class SmileFaces {
  
  public static int countSmileys(List<String> arr) {
      return (int)arr.stream().filter((str) -> Pattern.matches("[:;][-~]?[)D]", str)).count();
  }
}