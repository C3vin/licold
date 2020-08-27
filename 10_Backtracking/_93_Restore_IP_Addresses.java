class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        
        /** 1. Create a result container **/
        List<String> res = new ArrayList<>(); 
         
        /** 2. Corner case **/
        if(s == null || s.length() == 0 || s.length()> 12) return res;            
         
        int L = s.length(); 
        
        /** 3. Backtracking **/
        helper(s, L, res, new StringBuilder(), 0, 0); 
        
        return res; 
    
    }
    
                                                                               /* Number of point*/ 
    private void helper(String s, int L, List<String> res, StringBuilder sb, int pos, int count) {
        
        /* 1. if used up dot and total length */
        if(pos == s.length() && count == 3) {

            res.add(sb.toString()); 
            
            return; 
        }
        
        /** 2. overflow **/
        if(count > 3) return; 
        
        /** 3.  **/
        for(int i = pos; i < L; i++) {
            
            /* 3.1 Get possible segment */
            String t = s.substring(pos, i+1); 
            
            /* 3.2 check if segment invalid **/
            if(    t.length()>3   ||
                   t.length() > 1 && t.charAt(0) == '0' || 
                   Integer.valueOf(t) > 255) 
            break;
            
            /* 3.3 get the length of current substring **/
            int len = sb.length(); 
            
            /* 3.4 append to current substring */
            sb.append(t); 
            
            /* 3.5 insert dot */
            if( i == L -1 ) {
                 
                helper(s, L, res, sb, i+1, count); 
                
            } else {
                
                sb.append("."); 
                
                helper(s, L, res, sb, i+1, count+1); 
            }
            
            sb.setLength(len); 
        }   
        
    }
}
