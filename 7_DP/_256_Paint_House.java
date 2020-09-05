class Solution {
    
    public int minCost(int[][] costs) {

                /** If there is 0 house, then return 0 **/
                if(costs.length==0) return 0;

                /** The the cost for Red, Green, Blue respectively, for 1st house **/
                int lastR = costs[0][0];
                int lastG = costs[0][1];
                int lastB = costs[0][2];

                /** Check all expect 1st house **/
                for(int i=1; i<costs.length; i++){

                    int curR = Math.min(lastG,lastB)+costs[i][0]; /** check current Red's combination **/
                    int curG = Math.min(lastR,lastB)+costs[i][1]; /** check current Green's combination **/
                    int curB = Math.min(lastR,lastG)+costs[i][2]; /** check current Blue's combination **/

                     lastR = curR;
                     lastG = curG;
                     lastB = curB;

                }

                return Math.min(Math.min(lastR,lastG),lastB);
            }
    
}