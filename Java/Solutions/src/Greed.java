import java.util.HashMap;
import java.util.Hashtable;

public class Greed{
  public static int greedy(int[] dice){
    int points = 0;
    //HashMap<Integer,Integer> count = new HashMap{{put(1,0);}};
    HashMap<Integer,Integer> count = new HashMap<Integer, Integer>() {
      { put(1, 0); put(2, 0); put(3, 0); put(4,0); put(5,0); put(6,0);}
    };
    for(int die : dice)
    {
      count.put(die,count.get(die) + 1);
      if(count.get(die) == 3)
      {
        if(die == 1)
          points += 1000;
        else
          points += (100 * die);

        count.put(die,0);
      }
    }
    return points + (count.get(1) * 100) + (count.get(5) * 50);
  }
}

// Three 1's => 1000 points
// Three 6's =>  600 points
// Three 5's =>  500 points
// Three 4's =>  400 points
// Three 3's =>  300 points
// Three 2's =>  200 points
// One   1   =>  100 points
// One   5   =>   50 point