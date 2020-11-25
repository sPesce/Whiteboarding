import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
     // BigInt myInt = new BigInt(FactorialCalc.Factorial(10));
     // System.out.println("Created Big Int " + myInt.getValue());
    
      //System.out.println("x - x: " + myInt.minus(myInt));

      int[] nums = {100,50,30,22,11,7};
      for(int i = 0 ; i < 3 ; i += 2)
      {
        BigInt[] bInt = {new BigInt(nums[i]),new BigInt(nums[ i + 1 ])};
        System.out.println("Created big nums " + bInt[0].getValue() + " and " + bInt[1].getValue());
        System.out.println(bInt[0].getValue() + " - " + bInt[1].getValue() + " = " + bInt[0].minus(bInt[1]));
      }
    }

    private void testFactCalc(int n){
      String answer = FactorialCalc.Factorial(n);
      System.out.println("Length of String: " + answer.length());
      System.out.println("fac("+n+"):");
      System.out.println(answer);
    }

  }
