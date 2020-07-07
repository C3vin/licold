class Solution {
    
    public String convert(String s, int numRows) {
    
        if(numRows == 1) return s; 
        
        StringBuilder ret = new StringBuilder(); 
        
        int n = s.length(); // Get total length 
        
        int cycleLen = 2*numRows - 2;  //Get cycle's length --> numRows + (numRows-2)
       
        /* Loop every row */
        for(int i = 0; i < numRows; i++) {
            
            for(int j =0;  j + i < n;  j+=cycleLen){
                
                ret.append(s.charAt(j+i));
                
                   /* not top row */            /* no overflow */ 
                if( i!=0 && i!=numRows - 1 && j + cycleLen - i < n) {  // top and buttom row does not have add-on
                            /* not buttum row */
                     
                    ret.append( s.charAt(j + cycleLen - i) );
                    
                }
            } 
        }
        return ret.toString();
    }
}
