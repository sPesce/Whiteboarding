import java.util.Arrays;
public class Accumul {
    
  public static String accum(String s) {
    
    String[] acc = new String[s.length()];

    for(int i = 0; i < s.length(); i++)
    {
      final char current = s.charAt(i);
      char[] outpChars = new char[i+1];
      //fill with lowercase, but make [0] uppercase
      Arrays.fill(outpChars,Character.toLowerCase(current));
      outpChars[0] = Character.toUpperCase(current);
      
      acc[i] = new String(outpChars);
    }
    
    return String.join("-",acc);
  }
}
//accum("abcd") -> "A-Bb-Ccc-Dddd"
//accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
//accum("cwAt") -> "C-Ww-Aaa-Tttt"