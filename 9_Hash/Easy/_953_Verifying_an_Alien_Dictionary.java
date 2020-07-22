class Solution {

    int[] mapping = new int[26]; 
     
    public boolean isAlienSorted(String[] words, String order) {
        
        for(int i = 0 ; i < order.length(); i ++ ){
            
            mapping[ order.charAt(i) - 'a' ] = i; 
            
        }
        
        
        for(int j = 1; j < words.length; j++) {
            
            if( bigger(words[j], words[j-1]) )  return false; 
        }
        
        return true;
         
        
    }
     
    public boolean bigger(String a, String b){
        
        int m = a.length();
        int n = a.length(); 
        
        for(int i = 0; i < m && i < n ; i ++)  
            
            if( a.charAt(i) != b.charAt(i) )  
                 
               return mapping[a.charAt(i)-'a'] < mapping[b.charAt(i)-'a'];

        return a.length() < b.length(); 
        
    }
    
}
