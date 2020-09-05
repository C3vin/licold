/** DP  |  https://www.youtube.com/watch?v=MyJvMydR2G4&t=193s   **/

class Solution {
    
        public double knightProbability(int N, int K, int sr, int sc) {

            /** 1. 制造 dp  **/
            double[][] dp = new double[N][N];

            /** 2. 製造可以跳的位置  **/
            int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
            int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

            /** 3. 初始化起點為1  **/
            dp[sr][sc] = 1;

            /** 4. 遍歷N步  **/
            for (; K > 0; K--) {

                /** 4.1 建立 dp2 --> 会迟一点Copy给dp **/
                double[][] dp2 = new double[N][N];

                /** 4.2 行，列，遍歷  **/
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {

                        /** 當 dp[r][c] 有效 --> 不是0  **/
                        if(dp[r][c] != 0 ) {

                                            /** ~1 遍歷八個角度  **/
                                            for (int k = 0; k < 8; k++) {

                                                int cr = r + dr[k];
                                                int cc = c + dc[k];

                                                /** 如果沒出界 **/
                                                if (0 <= cr && cr < N && 0 <= cc && cc < N) {

                                                    /** 只有當 dp[r][c] 有效的時候，dp2才有效   **/
                                                    dp2[cr][cc] += dp[r][c] / 8.0;
                                                }
                                            }
                        }
                    }
                }

                /** 4.3 更新 dp  **/
                dp = dp2;
            }

            double ans = 0.0;

            /** 把所有的點，相加起來  **/
            for (double[] row: dp) {
                for (double x: row) ans += x;
            }

            return ans;
        }
}