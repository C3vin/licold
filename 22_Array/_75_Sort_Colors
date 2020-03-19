class Solution {
    
        public void sortColors(int[] nums) {
         
            int p0 = 0;
            int curr = 0;
         
            int p2 = nums.length - 1;

            int tmp;
            
            while (curr <= p2) {
                
                if (nums[curr] == 0) {
   
                    nums[curr++] = nums[p0];
                    
                    nums[p0++] = 0;
        
                }
                
                else if (nums[curr] == 2) {
              
                    nums[curr] = nums[p2];
                    
                    nums[p2--] = 2;
                }
                
                else curr++;
            }
        }
  
}