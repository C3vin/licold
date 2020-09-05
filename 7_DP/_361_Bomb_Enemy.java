class Solution {

        public int maxKilledEnemies(char[][] grid) {

            /** 边界条件 */
            if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;

            /**  */
            int max = 0;
            
            /** DP缓存 */
            int row = 0;
            int[] col = new int[grid[0].length];

            /** 遍历 */
            for(int i = 0; i<grid.length; i++){  // 行
                for(int j = 0; j<grid[0].length;j++){  // 列   // 這題畫圖看看

                    /** 遇到墙就跳过 */
                    if(grid[i][j] == 'W') continue;

                    /** 第j列，只在 --> j是0，或者j之前是墙   才行動 --> 就找出j之后的所杀敌人 */
                    if(j == 0 || grid[i][j-1] == 'W'){
                        row = Kill_Row(grid, i, j); // 更新 row 
                    }

                    /** 第i行，只在 --> i是0，或者i之前是墙   才行動 --> 就找出i之后的所杀敌人 */
                    if(i == 0 || grid[i-1][j] == 'W'){
                        col[j] = Kill_Col(grid,i,j); // 更新 col[]
                    }

                    /** 更新Max */
                    if(grid[i][j] == '0'){
                        max = (row + col[j] > max) ? row + col[j] : max;
                    }
                }
            }

            return max;
        }

        /** calculate killed enemies for row i from column j | 第i行，j位置后的，所有敌人*/
        private int Kill_Row(char[][] grid, int i, int j){
            int num = 0;
            while(j <= grid[0].length-1 && grid[i][j] != 'W'){
                if(grid[i][j] == 'E') num++;
                j++;
            }
            return num;
        }

        /** calculate killed enemies for column j, from row i | 第j列，i位置后的，所有敌人*/
        private int Kill_Col(char[][] grid, int i, int j){
            int num = 0;
            while(i <= grid.length -1 && grid[i][j] != 'W'){
                if(grid[i][j] == 'E') num++;
                i++;
            }
            return num;
        }
}