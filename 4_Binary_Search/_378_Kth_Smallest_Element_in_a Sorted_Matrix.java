public class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        int lo = matrix[0][0]; 
        int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        
        int len = matrix[0].length - 1;
          
        while(lo + 1 < hi) {
            
            int mid = lo + (hi - lo) / 2;
            
            int count = 0; 
            
            int j = len; 
            
            for(int i = 0; i < matrix.length; i++) {
                
                while(j >= 0 && matrix[i][j] > mid) j--;
                
                count += (j + 1);
            }
            
            if(count < k) lo = mid;
            else hi = mid;
        }
        
        int count = 0; 
        int j = len;
        
        for(int i = 0; i < matrix.length; i++) {
                
                while(j >= 0 && matrix[i][j] > lo) j--;
                
                count += (j + 1);
        }
 
        if(count < k) return hi; 
        else return lo;
    
    }
}