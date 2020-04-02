class Solution {
    
    // 什么是背包： https://www.youtube.com/watch?v=COFCShAEgv8 
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0;

        // 1. 计算总和
        for (int num : nums) {
            sum += num;
        }

        // 2. 看是否是偶数，如果不是 --> 无解 
        if ((sum & 1) == 1) {
            return false;
        }
        
        // 3. 分隔后的和
        sum /= 2;

        // 4. 初始化DP
        int n = nums.length;

        boolean[] dp = new boolean[sum+1];
        
        Arrays.fill(dp, false);

        // 5. 第一个元素是0
        dp[0] = true;

        // 6. 遍历每个元素
        for (int num : nums) {  //  自己拿纸算一下
            
            // 7. 从sum开始算
            for (int i = sum; i > 0; i--) {
            
                if (i >= num) {
                    
                    dp[i] = dp[i] || dp[i-num];
                }
            } 
        }

        return dp[sum];
    }

}