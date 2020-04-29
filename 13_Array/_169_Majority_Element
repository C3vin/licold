class Solution {
    
    /**Moore Voting Algorithm*/ // https://youtu.be/n5QY3x_GNDg?t=55  
    
    public int majorityElement(int[] num) {
        
        // majority will only be 1 because its count larger than n/2
        
        int major = Integer.MAX_VALUE;  // 先预定一个major
        
        int count = 0;      //  然后预定count为1
        
        // Loop --> check every element
        for(int i=0; i<num.length;i++){
            
            // if different 
            if(num[i]!=major){
 
                // when count is not Zero
                if(count != 0 ) count--; 
                
                // when count is Zero
                if(count == 0){
                    
                    major = num[i]; 
                    count++; 
                    
                }  
            }
            
            // if equal 
            if(major == num[i]) count++; 
   
        }   
        
        return major; 
    }
}