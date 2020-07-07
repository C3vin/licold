class Solution {
    
    public boolean validPalindrome(String s) {
        
        int L = 0;
        int R = s.length()-1; 
        
        while( L < R ){
            
            if( s.charAt(L) != s.charAt(R) ) {
                
                return isPalin(s, L + 1, R) || isPalin(s, L, R - 1); 
                
             }    
            
            L++; 
            R--; 
        }
        
        return true; 
    }
    
    public boolean isPalin(String s, int L, int R){
 
            while( L < R ) {
                
                if(s.charAt(L) != s.charAt(R)) return false; 
                
                L++; 
                R--;
                
            }
            return true; 
    }        
}