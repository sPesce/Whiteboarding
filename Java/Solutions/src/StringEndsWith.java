public class StringEndsWith {
  public static boolean solution(String str, String ending) {
    if (ending.length() > str.length()) return false;
    return str.equals(ending) || ending.equals(str.substring( str.length() - ending.length()));
  }
}
