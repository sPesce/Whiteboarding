import java.util.Arrays;
public class Accumul {
    
  public static String accum(String s) {
    
    final char[] letters = s.toCharArray();
    String[] acc = new String[s.length()];

    for(int i = 0; i < letters.length; i++)
    {
      StringBuilder sb = new StringBuilder();
      sb.append(Character.toUpperCase(letters[i]));

      
      char[] repeat = new char[i];
      Arrays.fill(repeat,Character.toLowerCase(letters[i]));
      sb.append(repeat);
      
      acc[i] = sb.toString();
    }
    
    return String.join("-",acc);
  }
}
//accum("abcd") -> "A-Bb-Ccc-Dddd"
//accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
//accum("cwAt") -> "C-Ww-Aaa-Tttt"