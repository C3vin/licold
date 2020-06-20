class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> wList = new HashSet(wordList); 
        
        if(!wList.contains(endWord)) return 0; 
        
        HashSet<String> forward = new HashSet<String>(); 
        HashSet<String> backward = new HashSet<String>(); 
  
        forward.add(beginWord); 
        backward.add(endWord);
        
        int L = endWord.length(); 
        
        int level = 1;
        
        while(!forward.isEmpty()) {
            
             HashSet<String> nextLayer = new HashSet<String>(); 
            
             wList.removeAll(forward); 
            
             for(String s1 : forward) {
                
                    char[] curr = s1.toCharArray(); 

                    for(int i=0; i<L; i++) {

                                    char X = curr[i]; 
 
                                    for(char c = 'a'; c<='z';c++){
 
                                             if(c == X) continue; 
                                                
                                             curr[i] = c; 
                                            
                                             String s2 = String.valueOf(curr); 
                                            
                                             if(backward.contains(s2)) return level + 1; 
                                           
                                             if(wList.contains(s2)) nextLayer.add(s2);
                                   }
                        
                                    curr[i] = X; 
                    }
              }
             
              if(nextLayer.size() > backward.size()){
                  
                  forward = backward; 
                  backward = nextLayer; 
                  
              } else {
                  
                  forward = nextLayer; 
              }
              level++;   
        }
        return 0;   
    }
    
}

