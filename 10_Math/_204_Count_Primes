    /**
     * 假設C，不是質數。那麼，C可以等於 M x N (這兩個因子，不能等於1或者C)
     *
     * ----------------
     *
     * 同時，假設C開根后是K.
     *
     * 那麼，M和N，必定，一個大於K，一個小於N。為什麼？
     *
     * 因為：
     * 1. 如果M和N同時小於K，則 M x N 永遠小於 C
     * 2. 如果M和N同時大於K，則 M x N 永遠大於 C
     *
     * ----------------
     *
     * 所以，如果C不是質數，那麼必定有一個因子，小於C的開根 - K。
     *
     * 於是，檢查 2 到 K是否能被C整除，就可以判定C是否質數了。
     *
     * ----------------
     *
     * 例子一：檢測51，先取根為7。檢測2，3，4，5，6，7是否能被51整除。如果不能，就是質數.
     *
     * 例子二：檢測49，先取根為7。檢測2，3，4，5，6，7是否能被51整除。如果能，就不是質數.
     *
     * **/
     
     
     
 class Solution {
            
        public int countPrimes(int n) {
            
            if(n <=1 ) return 0;

            /* 制造容器看有多少个质数 */
            boolean[] notPrime = new boolean[n]; 
            
            notPrime[0] = true; 
            notPrime[1] = true; 
 
            double nn =  Math.sqrt(n);  /* 这里 n 是代表的是 第n - 1个数字*/
            
            /* 对 2 - nn 来做判断 */
            for(int i = 2; i < nn; i++){
                
                /* 假设是质数，检查 */
                if(!notPrime[i]){
                    
                    /** 填满所有的nonPrime **/
                    for(int j = 2; j*i <= n-1; j++){
                        
                        notPrime[i*j] = true; 
                        
                    }
                    
                }
                
            }

            int count = 0; 
            
            /** 来数有多少个质数 **/
            for(int i = 2; i< notPrime.length; i++){
                
                if(!notPrime[i]) count++;
                
            }
            
            return count; 
        }
    
}
