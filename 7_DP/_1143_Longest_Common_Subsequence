class Solution {
    
    // Tutorial: Tushar Roy https://www.youtube.com/watch?v=NnD96abizww  
    
    public int longestCommonSubsequence(String text1, String text2) {
         
        // 制造DP房子
        int temp[][] = new int[text1.length() + 1][text2.length() + 1];

        // 制造结果变量
        int max = 0;
        
        // 遍历DP
        for(int i=1; i < temp.length; i++){
            
            for(int j=1; j < temp[i].length; j++){
                
                // 如果相等，就对角线+1
                if( text1.charAt(i-1) == text2.charAt(j-1) ) 
                    
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                
                // 如果不相等，就左面，上面，取最大
                else
                
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                
                // 随时更新 max
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;
        
        
    }
    
}