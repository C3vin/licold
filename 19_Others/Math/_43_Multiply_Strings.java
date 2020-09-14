class Solution {

      /**
        https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     * **/
    
    public String multiply(String num1, String num2) {
        
        /* 1. Get the length of the two strings */
        int m = num1.length();
        int n = num2.length();
 
        /* 2. 製造 m+n 長的 int[] */
        int[] pos = new int[m + n];

        /* 3. 把 num1 循環一遍 */
        for(int i = m - 1; i >= 0; i--) {
            
            /** 4. 把 num2 循環一遍 **/
            for(int j = n - 1; j >= 0; j--) {
                
                /* 4. multiply */
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                
                /** p1, p2 位置 **/
                int p_Low = i + j;
                int p_High = i + j + 1; // m-1 + n-1 + 1 是 POS 最后一个位置
                
                int sum = mul + pos[p_High];

                pos[p_Low] += sum / 10;
                pos[p_High] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        
        return sb.length() == 0 ? "0" : sb.toString();
        
    }

}
