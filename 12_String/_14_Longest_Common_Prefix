class Solution {
    
    public String longestCommonPrefix(String[] strs) {
            
        if(strs.length == 0) return ""; 
        
        String pre = strs[0];  /* 第一个String */
        
        for(int i=1; i<strs.length; i++){ /* 检查每一个 String */

            while(strs[i].indexOf(pre) != 0) {  // 等于0的意思就是，完全match了。这里就是一个一个找
                
                 pre = pre.substring(0, pre.length()-1);  
            
            } 
            
        }
        
        return pre;
    }    
} 
