public class Solution {
    
    // 其实可以转化成n个数字，其中一个出现了一次，其余的都出现了两次这样一个问题，异或经典问题
    
    public int missingNumber(int[] nums) {
        
        int ans = 0; 
        
        for (int i = 0; i <= nums.length; i ++)  ans ^= i;
        for (int i = 0; i <  nums.length; i ++)  ans ^= nums[i];
        
        return ans;
    }
}

