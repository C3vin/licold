class Solution {
    
        public boolean canJump(int[] nums) {

            /** 1. 求最後的位置  **/
            int lastPos = nums.length - 1;

            /** 2. 從後往前算  **/
            for (int i = nums.length - 1; i >= 0; i--) {

                /** 如果當前位置，加上當前位置的值，大於lastPos，就更新 lastPos 為i  **/
                if (i + nums[i] >= lastPos) lastPos = i;
            }

            /** 3. 看是否可以找到最開頭位置  **/
            return lastPos == 0;
        }
    
}
