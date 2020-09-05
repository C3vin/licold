class NumMatrix {
    
    /**
     * Tushar Roy | Video --> https://www.youtube.com/watch?v=PwDqpOMwg6U
     *
     *              GitHub --> https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Immutable2DSumRangeQuery.java
     * **/
    
        private int[][] T;

        public NumMatrix(int[][] matrix) {
            
            // 定义行，列
            int row = 0;
            int col = 0;
            
            if (matrix.length != 0) {
                row = matrix.length;
                col = matrix[0].length;
            }
            
            // 定义DP，初始化全部是0
            T = new int[row + 1][col + 1];
            
            for (int i = 1; i < T.length; i++) {
                for (int j = 1; j < T[0].length; j++) {
                    
                    // 这里自己拿笔划一下，一个是矩阵，一个是DP。（加上增加的，减去重叠的）
                    T[i][j] = T[i - 1][j] + T[i][j - 1] + matrix[i - 1][j - 1] - T[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            
            row1++;
            col1++;
            row2++;
            col2++;
                   // （加上增加的，减去重叠的）
            return T[row2][col2] - T[row1 - 1][col2] - T[row2][col1 - 1] + T[row1 - 1][col1 - 1];
        }
  
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */