import java.util.Hashtable;

public class Strings 
{
  public static int lengthOfLongestSubstring(String s) 
  {    
    int size = s.length();
    
    if(size < 2) return size;

    int start = 0;

    Hashtable<Character,Byte> counter = new Hashtable<>();
    int maxSize = 0;//longest substr length
    
    for(int i = 0; i < size; i++)
    {
      //if(maxSize > size/2) return maxSize;

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
        counter.put(current, (byte)i);
    }
    maxSize = newMax(maxSize, counter);
    return maxSize;    
  }
  public static int newMax(int maxSize, Hashtable<Character,Byte> counter)
  {
    int count = counter.size();
    return Integer.max(maxSize,count);
  }
}
