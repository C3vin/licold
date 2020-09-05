class Solution {
    
    public int uniquePathsWithObstacles(int[][] a) {

            int R = a.length;
            int C = a[0].length;

            if (a[0][0] == 1) return 0; 
            /** If the starting cell has an obstacle, then simply return as there would be no paths to the destination. **/
 
            a[0][0] = 1;

            for (int i = 1; i < R; i++) {                                         /** 檢測第一列 **/
                a[i][0] = ( a[i][0] == 0 && a[i - 1][0] == 1 ) ? 1 : 0;
            }

            for (int i = 1; i < C; i++) {                                         /** 檢測第一行 **/
                a[0][i] = (a[0][i] == 0 && a[0][i - 1] == 1) ? 1 : 0;
            }

            for (int i = 1; i < R; i++) {                                         /** 檢查中間的單位 **/
                for (int j = 1; j < C; j++) {
                    
                    if (a[i][j] == 0) {
                        a[i][j] = a[i - 1][j] + a[i][j - 1];
                    } else {
                        a[i][j] = 0;
                    }
                }
            }

            // Return value stored in rightmost bottommost cell. That is the destination.
            return a[R - 1][C - 1];
    }
}