class Solution {
    
    /** 快慢指針 | https://www.youtube.com/watch?v=WVfNtGL7ROM 籃子王  **/
    public int removeDuplicates(int[] nums) {

        /** 邊界條件  **/
        if (nums.length == 0) return 0;

        /** 定義 i **/
        int i = 0;

        /** j 是快指針 **/
        for (int j = 1; j < nums.length; j++) {

            /** 如果 i j 所在坐標的值不一樣，  **/
            if (nums[j] != nums[i]) {

                i++;
                nums[i] = nums[j];
            }
        }
        
        return i + 1;
    }
}
