public class Solution {

        public int minCostII(int[][] costs) {
 
            if(costs == null || costs.length == 0 || costs[0].length == 0) return 0; /** 邊界條件 **/
 
            int n = costs.length, k = costs[0].length; /** 房子的個數 n          顏色的個數 k  **/
 
            if(k == 1) return (n==1? costs[0][0] : -1);  /** Corner case  **/
 
            int preMin = 0;  /** previous 1st minimum  **/
            int prevSecMin = 0; /** previous 2nd minimum  **/  //prevSecMin always >= prevMin
            int prevMinInd = -1; /** 之前min的颜色坐标 **/
 
            for(int i = 0; i<n; i++) {  /** Traverse n house **/
 
                    int min = Integer.MAX_VALUE; /** Initiate current min, minInd, secMin **/
                    int secMin = Integer.MAX_VALUE;
                    int minInd = -1;
 
                    for(int j = 0; j<k;  j++) {  /** Traverse k colors **/

                            int val = costs[i][j] + (j == prevMinInd? prevSecMin : preMin);

                            /**
                             *          1             2             3            4
                             *
                             *         #red 1      ^red 2         red 7       #red 1
                             *         blue 5       blue 9       #blue 2      ^blue 7
                             *        ^green 3      green 4       green 9      green 7
                             *         yellow 4    #yellow 3     ^yellow 3     yellow 1
                             *
                             *         # means 1st minimum choice
                             *         ^ means 2nd minimum choice
                             * **/

                            if(minInd< 0) {               /** when min isn't initialized **/

                                min = val;   minInd = 0;

                            } else if(val < min) {        /** when val < min **/

                                secMin = min;      min = val;      minInd = j;

                            } else if(val < secMin) { /** when min <= val < secMin */

                                secMin = val;
                            }
                    }
                
                    preMin = min;      prevMinInd = minInd;      prevSecMin = secMin;
            }
            
            return preMin;
        }
    }

