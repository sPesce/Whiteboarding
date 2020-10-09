import java.util.Hashtable;
public class PangramChecker {
  public boolean check(String sentence){
    Hashtable<Character,Boolean> letterMap = new Hashtable<Character,Boolean>();
    int count = 0;

    for(char letter : sentence.toCharArray())
    {
      final char lower = Character.toLowerCase(letter);
      
      if(!letterMap.containsKey(lower) && Character.isLetter(lower))
      {
        letterMap.put(lower ,true);
        count++;
      }
    }
    return count == 26;
  }
}