public class BigInt {
  private String value;
  
  BigInt(int value) {
    this.value = Integer.toString(value);
  }
  BigInt(String value){
   this.value = value; 
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

  public void add(BigInt x)
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
}


