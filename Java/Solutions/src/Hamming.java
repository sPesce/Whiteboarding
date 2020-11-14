import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Hamming {

public static long hamming(int n) { 
  ArrayList<Long> h2,h3,h5,hammings;
  h2 = new ArrayList<Long>();
  h3 = new ArrayList<Long>();
  h5 = new ArrayList<Long>();
  hammings = new ArrayList<Long>();

  hammings.add(0L); hammings.add(1L);
  h2.add(1L); h2.add(2L);
  h3.add(1L); h3.add(3L);
  h5.add(1L); h5.add(5L);
  
  for(int i = 1; i < n; i++)
  {    
    long nextH = Math.min(h2.get(h2.size() - 1),Math.min(h3.get(h3.size() - 1), h5.get(h5.size() - 1)));
    hammings.add(i,nextH);
    
    if(h2.get(h2.size() - 1) == nextH) h2.add(hammings.get(h2.size()) * 2);
    if(h3.get(h3.size() - 1) == nextH) h3.add(hammings.get(h3.size()) * 3);
    if(h5.get(h5.size() - 1) == nextH) h5.add(hammings.get(h5.size()) * 5);
  }
  return hammings.get(n);
  }
}