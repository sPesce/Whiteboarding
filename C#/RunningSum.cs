public class Solution
{
    public int[] RunningSum(int[] nums)
    {
        int sum = 0;
        int[] solution = new int[nums.Length];

        for( int i = 0 ; i < nums.Length ; i++ )
        {
            sum += nums[i];
            solution[i] = sum;
        }
        return solution;
    }        
}    