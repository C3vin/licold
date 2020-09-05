class Solution {  //  Similar to 688
    
    //  https://youtu.be/HTnIFivp0aw?t=36
    //  https://leetcode.com/articles/knight-dialer/ 
    public int knightDialer(int N) {
 
        int MOD = 1_000_000_007;  /** 1. "我也不知道什麼意思"的方法 **/

        /** 2. 製造十個動作(对应于0-9)   0      1     2     3      4    5     6     7      8    9     **/
        int[][] moves = new int[][]{  {4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}  };
        
        /** 3. 製造DP --> 兩行，10排 **/
        int[][] dp = new int[2][10];
        
        /** 4. 初始化 第一行 為 1 **/
        Arrays.fill(dp[0], 1);
        
        /** 5. 跳N次 **/
        for (int hops = 0; hops < N-1; ++hops) {
    
                        // 一二行交换: 1, 0, 1, 0, 1, 0
                        int cur = (hops+1)%2;   
            
                        /** 5.1 填充DP --> 留意 (~hops & 1) **/
                        Arrays.fill(   dp[cur], 0   );

                        /** 5.2 十個按鍵  **/
                        for (int node = 0; node < 10; ++node){

                                    /** ~1 八個move（每個按鍵的） |  這裡（cur^1）代表舊世界，（cur）代表新世界 **/
                                    for (int nei: moves[node]) {

                                        /** 新的，加到舊的裡面去 **/
                                        dp[cur][nei] += dp[cur^1][node];

                                        /** 集體取模  **/
                                        dp[cur][nei] %= MOD;
                                    }
                        }
        }
        long ans = 0;
        long ansX = 0;

        /** 6. 拿到 對應 的行  **/
        for (int x: dp[ (N-1)%2 ])  ans += x;
      
        return (int) (ans % MOD);
    }
}