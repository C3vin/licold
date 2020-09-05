/**
     *           516. Longest Palindromic Subsequence
     *           https://www.youtube.com/watch?v=_nCsPn7_OgI&t=221s
* */

public class Solution {

        public int longestPalindromeSubseq(String s) {

            // 编程char array便于提取
            char[] str = s.toCharArray();
            
            // 制造DP
            int T[][] = new int[str.length][str.length];
            
            // 初始化，就是每个字母自己是Palindromic
            for(int i=0; i < str.length; i++){
                T[i][i] = 1;
            }
            
            // 从长度2开始计算
            for(int L = 2; L <= str.length; L++){
                
                // 根据长度来，算每一个substring的palindromic的情况
                for(int i = 0; i < str.length - L + 1; i++){
                    
                    // 子元素的终点
                    int j = i + L - 1;
                    
                    // 几种情况
                    if(L == 2 && str[i] == str[j]){
                        
                        T[i][j] = 2;
                        
                    }else if(str[i] == str[j]){
                        
                        T[i][j] = T[i + 1][j-1] + 2;
                        
                    }else{
                        
                        T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                    }
                }
            }
            
			// 最后取末尾这一点
            return T[0][str.length-1];
 
        }     
}