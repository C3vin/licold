public class Solution {

    /** DP **/
    public int numDecodings(String s) {

        int n = s.length();
        
        if (n == 0) return 0;

        int[] memo = new int[n+1];   //字符串長度加一

        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--){

            if (s.charAt(i) == '0') {
                
                continue;
                
            } else {
                
                memo[i] = ( Integer.parseInt( s.substring(i,i+2) )<=26 ) ? memo[i+1]+memo[i+2] : memo[i+1];
           
            }
        }
        return memo[0];
    }

    /**
     *      1421
     *      n = 4
     *
     *      原始      = [0 ,1 ,2 ,3 ,4 ] = memo = int[5]
     *      記數      = [4 ,2 ,2 ,1 ,1 ] = memo
     *      字符位置     1  4  2  1
     *
     *      總結：
     *            1. 用每個位置的字符，來疊加變化的可能性
     *            2. int[n-1]就是字符串最後一個位置
     *            3. 其實疊加，類似 Fibonacci
     * **/
}
