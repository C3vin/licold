class Solution {
    
    public boolean isHappy(int n) {
        
    Set<Integer> a = new HashSet<Integer>(); 
    
    int sum = 0;    
    int tmp = 0; 
        
    while(a.add(n)){
        
        sum = 0; 
         
        while(n > 0) {
            
          
            
           tmp = n%10; 
            
           sum = sum + tmp*tmp; 
            
           n = n/10;  
            
            
        }
        
        
        if(sum == 1) return true; 
        else n = sum; 
   
    } 
        
        
        
      return false; 
         
    }
}



 
