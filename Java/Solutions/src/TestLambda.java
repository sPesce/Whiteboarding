import java.util.*;
public class TestLambda {
  public static void printStuff(){
    ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));

    nums.forEach(NextSquare::findNextSquare);
  }
}
