class Solution {
    public int longestPalindrome(String s) {
        
        int len = s.length();
        
        if( len < 2) return len; 
        
        int[] hash = new int[256];    
        
        for(int i = 0; i < len; i++ ){
            
            char curr = s.charAt(i);
            
            hash[ curr ]++; 
            
        }
        
        int count = 0; 
        
        for(int j = 0; j < 256 ; j ++){
            
            int curr = hash[j]; 
            
            if( curr%2 == 0 ) count += curr; 
            if( curr%2 == 1 ) count += curr - 1; 
            
        }

        return count == s.length() ? count : count + 1;
    }
}