import java.util.*;
public class PangramChecker {
  public boolean check(String sentence){
    Hashtable<Character,Boolean> letterMap = new Hashtable<Character,Boolean>();
    char[] sentArr = sentence.toCharArray();

    for(char letter : sentArr)
    {
      letterMap.put(Character.toLowerCase(letter) ,true);
    }

    for(char letter = 'a'; letter <= 'z' ; letter++)
    {
      if (!letterMap.containsKey(letter))
        return false;
    }
    
    return true;
  }
}