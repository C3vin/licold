class Solution {
 
    public boolean wordBreak(String s, List<String> wordDict) {
    
        if(s==null || wordDict == null) return false; 
        
        HashSet<String> dict = new HashSet<String>(); 
        
        for(String str:wordDict) dict.add(str);
        
        boolean[] breakable = new boolean[s.length()+1]; 
        
        breakable[0] = true; 
        
        for(int i = 1; i <= s.length(); i++) {
            
            for(int j = 1; j <= i; j++) {
                
                    String sub = s.substring(i-j, i); 

                    if( dict.contains(sub) ) {

                        if( breakable[i-j] == true ) {
                            
                            breakable[i] = true;
                            break; 
                        }   
                    }   
            }            
        }   
        
      return breakable[s.length()];    
    }
}