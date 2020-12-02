/**
 * Created by Steve Pesce 11/25/2020
 * BigInt class for Large numbers
 * Currently only supports positive numbers
 * **/
public class BigInt implements Comparable<BigInt>{
  
  private String value;
  
  BigInt(int value) {
    if( value < 0) System.out.println("Caution: negative numbers not currently implemented");
    this.value = Integer.toString(value);
  }
  BigInt(String value){
   this.value = value; 
  }

  @Override
  public int compareTo(BigInt x){
    if(this.length() > x.length())
      return 1;
    if(this.length() < x.length())
      return -1;
    
    char[] thisChars = this.chars();
    char[] xChars = x.chars();

    for(int i = 0; i < this.length() ; i++)
    {
      int xInt = Character.getNumericValue(xChars[i]);
      int thisInt = Character.getNumericValue(thisChars[i]);
      
      if(thisInt > xInt) return 1;
      if(thisInt < xInt) return -1;
    }
    return 0;
  }

  public String getValue () {
    return value;
  }
  public void setValue(String value){
    this.value = value;
  }
  public void setValue(int value)
  {
    this.value = Integer.toString(value);
  }
  public char[] chars() {
    return this.value.toCharArray();
  }
  public int length(){
    return value.length();
  }
  
  //return two numbers as Strings of the same length (adds zeroes to front if shorter than other)
  private static String[] equalLengths(BigInt x, BigInt y){
    String yVal;
    String xVal;

    if(x.length() == y.length()){
      yVal = y.getValue();
      xVal = x.getValue();
    } else if(x.length() > y.length())
    {
      xVal = x.getValue();
      yVal =  "0".repeat(x.length() - y.length()) + y.getValue();
    } else
    {
      yVal = y.getValue();
      xVal = "0".repeat(y.length() - x.length()) + x.getValue();
    }

    return new String[] {xVal,yVal};
  }

  public void plus(BigInt x)
  {
    String[] xy = equalLengths(x, this);
    char[] xChars = xy[0].toCharArray();
    char[] yChars = xy[1].toCharArray();

    int overflow = 0;
    
    StringBuilder solution = new StringBuilder();
    for(int i = xChars.length - 1; i >= 0 ; i--)
    {
      int xInt = Character.getNumericValue(xChars[i]);
      int yInt = Character.getNumericValue(yChars[i]);
      int digitSum = xInt + yInt + overflow;

      solution.append( digitSum % 10);
      overflow = digitSum / 10;      
    }

    this.value = (overflow == 0 ? "" : "1") + solution.reverse().toString();
  }

  public void minus(BigInt x){
    int thisGThanX = this.compareTo(x);
    if (thisGThanX == 0)//numbers are equal, diff is zero
      this.setValue("0");
    else if(thisGThanX < 0)//diff would be negative
      this.setValue("ERROR, negative not implemented");
    else
    {    
      String[] xThis = equalLengths(x, this);
      char[] xChars = xThis[0].toCharArray();
      char[] thisChars = xThis[1].toCharArray();
      
      int overflow = 0;
      StringBuilder difference = new StringBuilder();
      for(int i = xChars.length - 1 ; i >= 0 ; i--)//subtraction happens in reverse order
      {
        int xInt = Character.getNumericValue(xChars[i]);
        int thisInt = Character.getNumericValue(thisChars[i]) + overflow;
        overflow = 0;//either 0 or -1, -1 when you need to take a 1 from the next 10s place up

        if(thisInt < xInt)
        {
          overflow = -1;
          thisInt += 10;
        }

        difference.append(thisInt - xInt);        
      }
      //trim zeroes
      //note the string builder is in reverse order, so leading zeroes are now at the end
      while(difference.charAt(difference.length() - 1) == '0')
        difference.deleteCharAt(difference.length() - 1);

      this.setValue(difference.reverse().toString());
    }
  }

  public void times(BigInt x) {
    char[] xChars = x.chars();
    String num = this.getValue();
    this.setValue(0);
    
    for(int i = 0; i < x.length(); i++)
    {
      int digit = Character.getNumericValue(xChars[xChars.length - 1 - i]);
      this.plus(new BigInt(multiplyByInt(digit, num, i)));
    } 
  }

  //make a deep copy by value
  public BigInt clone(){
    return new BigInt(this.getValue());
  }

  //'this' to the power of (exp)
  public void power(int exp)
  {
    BigInt clone = this.clone();
    this.setValue(1);
    
    for(int i = 1; i <= exp ; i++)
      this.times(clone); 
  }

  private static String multiplyByInt(int x, String num, int powerOf10) {
    return multiplyByInt(x, num, powerOf10, 0 , new StringBuilder());
  }

  //pops last digit, multiplies by x, adds it to string builder, sb to string on exit condition
  private static String multiplyByInt(int x, String num,  int powerOf10, int overflow, StringBuilder sb)
  {  //recursive exit cond. will return string from sb, add overflow if nonzero
    if(num.length() == 0)
    {
      return (overflow == 0 ? "" : Integer.toString(overflow)) 
      + sb.reverse().toString()
      + "0".repeat(powerOf10);
    }

    //add last digit * x to string builder
    final char digit = num.toCharArray()[num.length() - 1];
    final int product = Character.getNumericValue(digit) * x + overflow;
    sb.append(product % 10);
    
    //num loses last char, overflow calculated from product
    return multiplyByInt(x, num.substring(0, num.length() - 1), powerOf10, product / 10 , sb);
  }
  //divide by and set to new value
  public void divideBy(int divisor) {
    StringBuilder quotient = new StringBuilder();

    char[] dividend = this.chars();

    int overflow = 0;

    for(int i = 0; i < dividend.length ; i++)
    {
      int digit = overflow * 10 + Character.getNumericValue(dividend[i]);
      quotient.append(digit / divisor);
      overflow = digit % divisor;
    }
    // //trim zeroes
    while(quotient.charAt(0) == '0')
      quotient.deleteCharAt(0);
    this.setValue(quotient.toString());
  }
  //TODO: This was used in something that returns a string, but BigInt mutates the string value instead
  // how to fix?
  // private static String Factorial(int n) {
  //   //recursively call this method, which calls recursive multiply method
  //   if(n > 1) return multiply(n, Factorial(n-1),0,new StringBuilder());
  //   return "1";
  // }
}




