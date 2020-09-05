public class Solution {
 
        public int maxProfit(int[] prices) {
 
            if (prices == null  || prices.length <= 1) { return 0; }

            int n = prices.length;

            // 制造两个DP,初始值全部为0
            int[] hold = new int[n];
            int[] unhold = new int[n];

            // 初始情况
            hold[0] = - prices[0];
            unhold[0] = 0; 

            /**  {1,2,3,0,2}; */

            for (int i = 1; i < n; i++) {  // 下面的思路看视频 

                /** 持股 */
                if (i == 1) {
                    
                    hold[1] = Math.max( hold[0] /* - prices[0] */,  -prices[1] );
                    
                } else {
                    
                    hold[i] = Math.max( 
                        
                                        hold[i - 1] /*之前就持有*/,  
                        
                                        unhold[i - 2] - prices[i]/* 之前不持有。
                                        
                                                                    如果前天卖了，(i-2)
                                                                    昨天冷静，不变
                                                                    今天继续买。

                                                                    如果昨天卖了，(i-1)
                                                                    今天不能买*/
                                      );
                }
                
                /** 不持股 */
                unhold[i] = Math.max( unhold[i - 1], hold[i - 1] + prices[i] );
            }
            
            return unhold[n-1];
        }
}