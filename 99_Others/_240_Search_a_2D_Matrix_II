class Solution {
    
      public boolean searchMatrix(int[][] matrix, int target) {

            /** 1. 準備參數  **/
            // start our "pointer" in the bottom-left
            int row = matrix.length-1;
            int col = 0;

            /** 2. 從下往上，走；從左往右走  **/
            while (row >= 0 && col < matrix[0].length) {

                if (matrix[row][col] > target) {
                    row--;
                } else if (matrix[row][col] < target) {
                    col++;
                } else { // found it
                    return true;
                }
            }
            return false;
        }
    
}
