import java.util.Hashtable;

public class Strings 
{
  public static int lengthOfLongestSubstring(String s) 
  {    
    int size = s.length();
    
    if(size < 2) return size;


    Hashtable<Character,Integer> counter = new Hashtable<>();
    int maxSize = 0;//longest substr length
    
    for(int i = 0; i < size; i++)
    {
      char current = s.charAt(i);
      
      if(counter.containsKey(current))
      {
        maxSize = newMax(maxSize, counter);
        if(i < size - 1)
        {
          i = counter.get(current);
          counter = new Hashtable<>();
        }
      }
      else
        counter.put(current, i);
    }
    maxSize = newMax(maxSize, counter);
    return maxSize;    
  }
  public static int newMax(int maxSize, Hashtable<Character,Integer> counter)
  {
    int count = counter.size();
    return Integer.max(maxSize,count);
  }
}


/**
 * 
 * Runtime: 175 ms, faster than 6.40% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.5 MB, less than 8.07% of Java online submissions for Longest Substring Without Repeating Characters.
 * 
 * --try 2--
 * Runtime: 158 ms
 * Memory Usage: 40 MB
*/