class Solution {
    
      public int findCheapestPrice(int n, int[][] flights, 
                                    int src, int dst, int K) { /** Bellman–Ford **/
           
            /** 1. 制造兩排 DP  **/
            int[][] dist = new int[2][n];

            /**  dis = dist[0] and pre = dist[1] **/

            /** 2. 製造INF  **/
            int INF = Integer.MAX_VALUE / 2;

            /** 3. 填充DP的兩排  **/
            Arrays.fill(dist[0], INF);
            Arrays.fill(dist[1], INF);

            /** 4. 初始化 出發點  **/
            dist[0][src] = dist[1][src] = 0;
 
            int cur = 0; 
           
            for (int i = 0; i <= K; ++i) { //每跳一次，下面回遍历所有flight
 
                    for (int[] edge : flights) {
  
                        /** edge[0]是起点
                            edge[1]是終點
                            
                            edge[2]是花费
                        **/
                          
                        cur = i & 1; 
                         
                        dist[ cur ][ edge[1] ] = Math.min(  // i * 1 是奇偶行交替
                            
                                  dist[ cur ][ edge[1] ],  
                            
                                  dist[ ~cur & 1 ][edge[0]] /** 出發點的上一次最低開銷 **/  +   
                            
                                  edge[2] /** 當前的最低開銷 **/ 
                        );
                    }
            }
        
            if(         dist[ cur ][ dst ] < INF ) {
                
                return dist[ cur ][ dst ];
            }
             
            return -1;
        }
}

