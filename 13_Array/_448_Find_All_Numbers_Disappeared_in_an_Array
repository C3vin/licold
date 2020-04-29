class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
         
        /** 1. 制造結果集合  **/
        List<Integer> ret = new ArrayList<Integer>();

        /** 2. 遍歷 nums  **/
        for(int i = 0; i < nums.length; i++) {

                /** ~1 拿到對應的index  **/
                int val = Math.abs(nums[i]) - 1;

                /** ~2 如果沒探測過，變成負數 **/
                if(nums[val] > 0) {
                    nums[val] = -nums[val];
                }
        }

        for(int i = 0; i < nums.length; i++) {

            /** 沒變成負數的，就是沒檢查過的。 **/
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }

        return ret;
        
    }
    
}