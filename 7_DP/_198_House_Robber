class Solution {
    
    // https://youtu.be/-i2BFAU25Zk?t=108
    
    public int rob(int[] nums) {
        
        /** 代表上一個房子，是被搶了（yes），還是沒有（no）  **/
        int rob = 0;
        int notRob = 0;

        /** Traverse all house  **/
        for (int num : nums) {
                
            int pre = Math.max(rob, notRob); 
            
            rob = notRob + num; 
            
            notRob = pre; 

        }

        return Math.max(rob, notRob);
        
    }
    
}