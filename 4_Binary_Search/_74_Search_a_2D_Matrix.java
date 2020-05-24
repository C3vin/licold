class Solution {
   
    public boolean searchMatrix(int[][] matrix, int target) {
     
            int m = matrix.length;        if(m == 0) return false; 
            int n= matrix[0].length;      if(n == 0) return false; 
          
            int left = 0; 
            int right = m*n -1; 

            int mid; 
            int midValue; 

            while(left + 1 < right) {

                mid = left + (right - left)/2; 

                midValue = matrix[ mid/n ][ mid%n ]; 

                if(target == midValue) return true; 

                if(target < midValue) right = mid;
                else left = mid; 

            }

            int leftValue = matrix[ left/n ][ left%n ];
            int rightValue = matrix[ right/n ][ right%n ];        

            if(leftValue == target || rightValue == target) return true;

            return false; 
    }
}