import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
      BigInt myInt = new BigInt(21);
      System.out.println("Created Big Int " + myInt.getValue());
      myInt.add(new BigInt(135));
      System.out.println("Added 135 to 20 : " + myInt.getValue());
    }

    private void testFactCalc(int n){
      String answer = FactorialCalc.Factorial(n);
      System.out.println("Length of String: " + answer.length());
      System.out.println("fac("+n+"):");
      System.out.println(answer);
    }

  }
