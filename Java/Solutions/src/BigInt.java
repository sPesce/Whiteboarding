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

  public String plus(BigInt x)
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

    return this.value = (overflow == 0 ? "" : "1") + solution.reverse().toString();
  }

  public String minus(BigInt x){
    int thisGThanX = this.compareTo(x);
    if (thisGThanX == 0)//numbers are equal, diff is zero
      return value = "0";
    else if(thisGThanX < 0)//diff would be negative
      return value = ("ERROR, negative not implemented");
    
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

      return value = difference.reverse().toString();
    }

  

  
}


