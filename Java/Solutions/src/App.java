import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
      BigInt bI = new BigInt(1);
      BigInt bI2 = new BigInt(5);
      System.out.println("1 > 5 : " + (bI.compareTo(bI2)));
      System.out.println("5 > 1 : " + bI2.compareTo(bI));
      System.out.println("5 == 5 : " + bI.compareTo(bI));
      
    }

    private void testFactCalc(int n){
      String answer = FactorialCalc.Factorial(n);
      System.out.println("Length of String: " + answer.length());
      System.out.println("fac("+n+"):");
      System.out.println(answer);
    }

  }
