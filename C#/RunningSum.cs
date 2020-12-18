public class Solution {
    public int[] RunningSum(int[] nums) {
      public int sum = 0;
      public int[] solution = new int[nums.length()];
     
      for(int i = 0; i < nums.length(); i++)
      {
        sum += nums[i];
        solution[i] = sum;
      }

      return solution;
    }
}