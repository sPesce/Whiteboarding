import java.util.Hashtable;

public class Strings 
{
  public static int lengthOfLongestSubstring(String s) {return lengthOfLongestSubstring(s,0);}
  public static int lengthOfLongestSubstring(String s, int longest) 
  {    
    int size = s.length();
    
    if(size < 2) return size;

    Hashtable<Character,Integer> counter = new Hashtable<>();
    int maxSize = longest;//longest substr length
    
    for(int i = 0; i < size; i++)
    {
      //if(maxSize > size/2) return maxSize;

      char current = s.charAt(i);
      
      if(counter.containsKey(current))
      {
        System.out.println("'" + current + "' repeated");
        System.out.println("Max size is: " + maxSize);
        maxSize = newMax(maxSize, counter);
        if(i < size - 1)
        {
          maxSize = lengthOfLongestSubstring( s.substring(counter.get(current) + 1), maxSize);
          System.out.println(s.substring(counter.get(current) + 1) + ": " + maxSize);
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
*/