class Solution {
    
      public int[][] generateMatrix(int n) {
          
        int[][] res = new int[n][n];
    
        int cur = 1;
          
        int row_Begin = 0;
        int row_End = n - 1;
          
        int col_Begin = 0;
        int col_End = n - 1;
        
        while(cur <= n * n) {
            
                int i = row_Begin;
                int j = col_Begin;
            
                //left to right
                for(j = col_Begin ; j <= col_End; j++){
                    res[row_Begin][j] = cur++;
                }
                row_Begin++;
            
                //top to bot
                for(i = row_Begin ; i <= row_End; i++){
                    res[i][col_End] = cur++;
                }
                col_End--;
            
                //right to left
                for(j = col_End ; j >= col_Begin; j--){
                    res[row_End][j] = cur++;
                }
                row_End--;
            
                //bot to top
                for(i = row_End; i >= row_Begin; i--){
                    res[i][col_Begin] = cur++;
                }
                col_Begin++;
        }
          
        return res;
    }
    
}