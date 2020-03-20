class Solution {
 
        // Basket Wang: https://www.youtube.com/watch?v=2Yk3Avrzauk 
    
        public int maximalRectangle(char[][] matrix) {

            /** 1. 邊界條件 **/
            if (matrix.length == 0) return 0;

            /** 2. 最大面積 參數 **/
            int maxarea = 0;

            /** 3. 製造dp  **/
            int[] dp = new int[matrix[0].length];

            /** 4. 一行一行遍歷  **/
            for(int i = 0; i < matrix.length; i++) {

                /** 4.1 一排一排遍歷  **/
                for(int j = 0; j < matrix[0].length; j++) {

                    /** update the state of this row's histogram using the last row's histogram by keeping track of the number of consecutive ones **/

                    /** ~1 更新DP  **/
                    dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
                }

                /** 4.2 更新 maxarea 用更新过的DP **/
                maxarea = Math.max(maxarea, leetcode84(dp));

            } return maxarea;
        }

        /** 4.2 更新 maxarea **/ // Get the maximum area in a histogram given its heights
        public int leetcode84(int[] heights) {

            /** ~1 製造stack  **/
            Stack< Integer > stack = new Stack < > ();

            /** ~2 預設為 -1   **/
            stack.push(-1);

            /** ~3 製造變量  **/
            int maxarea = 0;

            /** ~4 遍歷  **/
            for (int i = 0; i < heights.length; ++i) {

                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){

                    maxarea = Math.max( maxarea,  heights[stack.pop()] * (i - stack.peek() - 1) );
                }

                stack.push(i);
            }

            /** ~5 剩下的stack元素重跑一遍  **/
            while (stack.peek() != -1)
                maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
            
            return maxarea;
        }
    
}