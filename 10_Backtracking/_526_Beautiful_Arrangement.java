class Solution {
 
    int count = 0;
    
    public int countArrangement(int N) {
        
        if (N == 0) return 0;
        
        helper(N, 1, new int[N + 1]);
        
        return count;
        
    }
    
    /* Core function */                    /* used */
    private void helper(int N, int pos, int[] used) {
        
        /* 1. count one more when position is full*/
        if (pos > N) {
            
            count++;
            return;
        }
        
        /* 2. 把不同的元素放到这个position  */
        for (int i = 1; i <= N; i++) {
            
                 /* 元素未使用过*/        /* 满足题目条件的话 */  
            if ( used[i] == 0    &&    ( i % pos == 0 || pos % i == 0 ) )  {
                
                used[i] = 1;
                
                          /* 元素的位置 */  
                helper(N, pos + 1,        used);
                
                
                used[i] = 0;  /* backtrack */
            }
            
        }
    }
}
