class TriangleTester {
  public static boolean isTriangle(double a, double b, double c){
    //each side must be less than sum of other 2 sides
    if (!((a + b > c) && (b + c > a) && (c + a > b))) return false;  
    
    double P = (a+b+c)/2.0;//perimiter
    return (Math.sqrt((P*(P-a)*(P-b)*(P-c))) > 0.0);//Area must be > 0
  }
}