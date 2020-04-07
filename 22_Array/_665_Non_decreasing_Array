class Solution {
    
    public boolean checkPossibility(int[] nums) {
        
         int n = nums.length, count = 0;

            /** 全部循環一遍 **/
            for (int i = 0; i + 1 < n; i++) {

                /** 如果 **/
                if (nums[i] > nums[i + 1]) {

                    count++;

                    /** 檢查 i+1 和 i-1 位置的關係 **/
                    if (  i > 0 && nums[i - 1] > nums[i + 1] ) {
                        
                                                                   nums[i + 1] = nums[i];
                    } else nums[i] = nums[i + 1];
                }
            }
        
            return count <= 1;
    }
}