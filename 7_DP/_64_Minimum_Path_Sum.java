class Solution {
    
    // Tutorial: https://www.youtube.com/watch?v=lBRtnuxg-gU  
    
     public int minPathSum(int[][] grid) {
         
        int m = grid.length;// row
        int n = grid[0].length; // column
         
        grid[i][j] = grid[i][j];
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // 第一行
                if (i == 0 && j != 0) {
                    
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                    
                // 第一列    
                } else if (i != 0 && j == 0) {
                    
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                    
                // 第一个字母    
                } else if (i == 0 && j == 0) {
                    
                    grid[i][j] = grid[i][j];
                    
                // 其他位置    
                } else {
                    
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}