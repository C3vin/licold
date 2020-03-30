class Solution {
    
    public int rob(int[] nums) {

        /** 此題，和 House_Robber_I 是一樣的
         *
         *  除了一點：最後一個房子，和第一個房子連在一起
         *
         *
         *  所以，只要考慮 0 - (n -2) 和 1 - (n-1) 的情況就行了
         *
         *
         *  why?
         *
         *  總共有 0 1 2 3 4 ... (n-1) 個房子，一共 n 個房子
         *
         *
         *  如果我偷第 0 個房子，那麼第 n-1 的房子我不能偷，只能偷到 n-2
         *
         *  如果我不偷第 0 個房子，那麼能偷到 1 - （n-1） 的房子
         *
         * **/

        if (nums.length == 1) return nums[0];

        return Math.max( rob_event( nums, 0, nums.length - 2), rob_event(nums, 1, nums.length -1) );

    }
    
    public int rob_event(int[] nums, int lo, int hi) {

        /** 代表上一個房子，是被搶了（yes），還是沒有（no）  **/
        int prev_No = 0;
        int prev_Yes = 0;

        /** Traverse all house  **/
        for (int i = lo; i <= hi; i++ ) {

            /** 上個房子 沒搶的情況下 的錢，傳遞給臨時參數 **/
            int prev_No_temp = prev_No;

            /** 現在房子不搶，有多少錢 **/
            prev_No   =   Math.max(prev_No, prev_Yes);

            /** 現在開槍搶，有多少錢 **/
            prev_Yes  =   nums[i] + prev_No_temp;

        }

        return Math.max(prev_No, prev_Yes);
    }
    
}