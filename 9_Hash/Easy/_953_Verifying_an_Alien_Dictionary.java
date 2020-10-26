class Solution {
    
    List<Character> hash; 
     
    public boolean isAlienSorted(String[] words, String order) {
         
        hash = new LinkedList<>(); 
        
        for(char k : order.toCharArray()){
            
            hash.add(k);
             
        }
        
        for(int i = 0; i < words.length - 1; i++){
            
            if( biggerOrNot(words[i], words[i+1]) ) {
                
                return false; 
            }
            
        }
        
        return true; 
        
    }
    
    public boolean biggerOrNot(String a, String b){
        
        int aLen = a.length(); 
        int bLen = b.length(); 

        int curr = 0; 
        
        while(curr < aLen && curr < bLen){
            
            if(a.charAt(curr) != b.charAt(curr)){
                
                return hash.indexOf(a.charAt(curr)) > hash.indexOf(b.charAt(curr));
            }
            
            curr++; 
            
        }
        
        return aLen > bLen; 
             
    } 
         
}