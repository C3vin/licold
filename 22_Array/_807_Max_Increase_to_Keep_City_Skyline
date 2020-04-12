/** Approach #1: Row and Column Maximums **/
class Solution {

        public int maxIncreaseKeepingSkyline(int[][] grid) {

            int N = grid.length;

            /** 1. 取得每行，每列的Max **/
            int[] rowMaxes = new int[N];
            int[] colMaxes = new int[N];

            /** 2. 遍歷  **/
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c) {

                    /** ~ 獲取每行每列最大值 **/
                    rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                    colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
                }

            /** 3. 制造答案  **/
            int ans = 0;

            /** 4. 遍歷  **/
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c)

                    ans += Math.min(rowMaxes[r], colMaxes[c])/** 這裡取最小的一個 **/ - grid[r][c];

            return ans;
        }
}