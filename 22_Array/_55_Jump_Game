public class Solution {
   
    public boolean canJump(int[] nums){
    
        /* 1. 边界条件 */
        if(nums.length <2) return true; 
        
        /* 2. 初始值 */
        int reach =0; 
        int i = 0; 
        
        /* 3. 循环 */
        for (i=0; i <nums.length && i <= reach; i++) {
            
            reach = Math.max(nums[i]+i, reach); 
            
            if(reach >= nums.length - 1) return true; 
            
        }
        
        return false; 
    }
    
}
