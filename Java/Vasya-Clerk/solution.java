public class Line {
  public static String Tickets(int[] peopleInLine)
  {
        if (peopleInLine == null)
          return null;
                 
        int myBalance[] = new int[101];
        myBalance[25] = 0;
        myBalance[50] = 0;
        myBalance[100] = 0;
        
        String valid = "YES";
        
        for(int bill : peopleInLine)
        {
            myBalance[bill] += 1;
            int userBalance = 0 - (bill - 25);
            if(bill == 100)//make 75 change
            {
                if(myBalance[50] >= 1)//exchange a $50
                {
                    myBalance[50]--;
                    userBalance += 50;
                }
                if(myBalance[25] >= -(userBalance/25) )
                {
                    //exchange neccasary $25s to balance user
                    userBalance = 0;
                    myBalance[25] -= -(userBalance/25);
                }
            }
            else if(bill == 50)
            {   //needs one $25 bill back
                if(myBalance[25] >= 1)
                {
                    myBalance[25]--;
                    userBalance = 0;
                }
            }
            if(userBalance != 0)
                 valid = "NO";
        }
        
        return valid;
    
  }
}
