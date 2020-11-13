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
  
  if(hammings.size() > n) return hamming(n);
  
  hammings.add(Math.min(h2.))


  
  }
}