class Solution {
    
    /**
    * https://leetcode.com/articles/subarray-sums-divisible-by-k/  解题
      
      Prefix Sums and Counting 
      https://youtu.be/pkx6SowjL7M?t=347 
    * **/
    public int subarraysDivByK(int[] A, int K) {

        int N = A.length;

        int[] P = new int[N + 1];

        for (int i = 0; i < N; ++i) P[i + 1] = P[i] + A[i];

        int[] count = new int[K];

        for (int x : P) {
            
            count[ (x % K + K) % K ]++;  /** 为什么是这种方式呢？  为了把负余数，变成正数  **/
            
        }

        int ans = 0;

        for (int v : count)
            ans += v * (v - 1) / 2;
        
        return ans;
    }   
}