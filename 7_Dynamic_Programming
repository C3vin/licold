 
class Solution {
    
  public int findLength(int[] A, int[] B) {
      
        int m = A.length, n = B.length;
      
        /** Create DP container **/
        int[][] dp = new int[m + 1][n + 1];
      
        int max = 0;
        
        /** Check with A **/
        for (int m_cuur = 1; m_cuur <= m; m_cuur++) {
            
            /** Scan for B **/
            for (int n_curr = 1; n_curr <= n; n_curr++) {
                
                /** If there is a match **/
                if (A[m_cuur - 1] == B[n_curr - 1]) {
                    
                    /** update with DP **/
                    dp[ m_cuur ][ n_curr ] = dp[m_cuur - 1][n_curr - 1] + 1;
                    
                    /** Update for Max **/
                    max = Math.max( max, dp[m_cuur][n_curr] );
                }
            }
        }
      
        return max;
    }
    
}
