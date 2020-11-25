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
  
  public void add(BigInt x)
  {
    int longest = Integer.max(x.length(),this.length());
    int overflow = 0;
    
    for(int i = 0; i < longest; i++)
    {
      int a = 
    }

  }
}


