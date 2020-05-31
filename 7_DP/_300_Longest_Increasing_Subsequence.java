public class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        if (nums.length == 0) return 0;
      
        int[] dp = new int[nums.length];
        
        dp[0] = 1;
        
        int maxAns = 1;
        
        int maxVal = 0; 
        
        for (int i = 1; i < dp.length; i++) {
            
            maxVal = 0;
            
            for (int j = 0; j < i; j++) {
                
                if (nums[j] < nums[i])  maxVal = Math.max(maxVal, dp[j]);
    
            }
            
            dp[i] = maxVal + 1; 
            
            maxAns = Math.max(maxAns, dp[i]); // 最后跟老大比
            
        }
        
        return maxAns;  
    }
}