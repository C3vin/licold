public class Solution {
    
    /* BasketWang 神一样的讲解 https://youtu.be/pi7ttqr1MT4?t=364 */
    
    public String longestPalindrome(String s) {
        
        if( s.isEmpty() ) return s;
        
        int len = s.length(); 
        
        char[] sChar = s.toCharArray(); 
        
        int start = 0; 
        int length = 1; 
        
        boolean[][] isPalindrone = new boolean[len][len]; 
        
        /* Input True for all char itself */
        for(int i = 0; i < len; i++) {
            isPalindrone[i][i] = true;
        }
    
        /* Input True for all adjacent chars */
        for (int i = 0; i< len-1; i++){
            
            if(sChar[i] == sChar[i+1]) {
                
                isPalindrone[i][i+1] = true;    
                
                start = i;
                length = 2;   //update the length;
            }
        }
        
        /* i: 当前子序列的长度
           j: 起点的位置
        */
        for(int i = 3; i <= len; i++) {
            
            for(int j = 0; j + i <= len; j ++) {
                  
                    /* 当前的相等 */              /* 并且往内走一步，是有效的回文 */
                if( sChar[j] == sChar[j+i-1] && isPalindrone[j+1][j+i-2] == true) {
                    
                    isPalindrone[j][j+i-1] = true;
                    
                    start = j;
                    length = i;  /* 最后发现的一定是长度最长的，不需要做判断 */
                }
            }
   
        }
        
        return s.substring(start, start+length); 
    }
}