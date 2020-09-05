class Solution {
 
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;

        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
 
                int cur = nums[i];    
            
                int M = curMax;

                curMax = Math.max(     Math.max( M * cur, curMin * cur ),      cur   );

                curMin = Math.min(     Math.min( M * cur, curMin * cur ),      cur   );

                res = Math.max(res, curMax);

        }

        return res;
    }
}
 
    
    