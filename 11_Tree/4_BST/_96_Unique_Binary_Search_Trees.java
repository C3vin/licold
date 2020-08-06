class Solution {
 
    public int numTrees(int n) {
        
      int [] dp = new int[n+1];
        
      dp[0] = dp[1] = 1;
         
      for(int i=2; i<=n; ++i) {
          
        for(int j=0; j < i; ++j) {
            
          dp[i] += dp[ j ] * dp[ i- j - 1];
            
        }
      }
      return dp[n];
    }
}
 
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution {
 
    public int numTrees(int n) {
         
       return dfs(1, n);             
     
    }
    
    public int dfs(int left, int right){
        
        int res = 0; 
         
        if(left >= right) return 1;  // base case
        
        for(int i = left; i <= right; i++ ){
      
            int L = dfs( left, i - 1 ); 
            
            int R = dfs( i+1,  right ); 

            res += L*R; 
        }
        return res;  
    }
}

  
