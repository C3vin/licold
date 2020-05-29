class Solution {
    
    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down) {
         
        if (left > right || up > down) { 
            return false;
   
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;
 
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }

    public boolean searchMatrix(int[][] mat, int targ) {
 
        matrix = mat;
        target = targ;
 
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
}
 
/////  O(m+n)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Solution {
	
    public boolean searchMatrix(int[][] matrix, int target) {
		
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) return false;
       
        int col = matrix[0].length-1;
        int row = 0; 
		
        while(col >= 0 && row <= matrix.length-1) {
			
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}








