public class StringEndsWith {
  public static boolean solution(String str, String ending) { 
    return ending.equals(str.substring( str.length() - ending.length()));
  }
}
