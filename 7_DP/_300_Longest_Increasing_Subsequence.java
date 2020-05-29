////////////////////////////////////////   DP
class Solution {
  
        public int lengthOfLIS(int[] nums) {

            int[] dp = new int[nums.length];
            
            int len = 0;
            
            for (int x : nums) {

                int index = Arrays.binarySearch(dp, 0, len, x);
                
                if (index < 0) index = -(index + 1);
                
                dp[index] = x;
                
                if (index == len) len++;    
            }
            return len;
        }
}