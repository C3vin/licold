public class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        if(amount<1) return 0;
        
        int[] dp = new int[amount+1];
        
        int sum = 1;

        while( sum <= amount ) {
            
                int min = -1;

                for(int coin : coins) {

                    if( coin <= sum && dp[sum-coin]!=-1 ) {

                        int temp = dp[sum-coin] + 1;
 
                        if(min == -1){

                            min = temp; 

                        } else {

                            min = temp < min ? temp : min ;
                        }


                    }
                }   

                dp[sum] = min;
            
                sum++; 
            
        }
        
        return dp[amount];
    }
}