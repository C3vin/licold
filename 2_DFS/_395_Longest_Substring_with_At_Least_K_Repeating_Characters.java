public class Solution {
    
    public int longestSubstring(String s, int k) {
        
        if (s == null || s.length() == 0) return 0;
        
        char[] chars = new char[26];
      
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
      
        boolean flag = true; // to test success case below;
        
        for (int i = 0; i < chars.length; i += 1) if (chars[i] < k && chars[i] > 0) flag = false;
        
        if (flag == true) return s.length();
        
        //////////// whole string success case above ////////
        
        int result = 0;
        int start = 0;
        int cur = 0;
 
        while (cur < s.length()) {
            
            int m = chars[s.charAt(cur) - 'a'];  
            
            if (m != 0 && m < k ) {
                
                result = Math.max( result, longestSubstring( s.substring(start, cur), k ) );
                
                start = cur + 1;
            }
            
            cur++;
        }
        
        result = Math.max(result, longestSubstring(s.substring(start), k));
        
        return result;
    }
}