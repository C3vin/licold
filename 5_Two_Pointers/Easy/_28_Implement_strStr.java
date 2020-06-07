class Solution {
    
     public int strStr(String haystack, String needle) {
        
        int h = haystack.length(); 
        int n = needle.length();
 
        for (int i = 0; ; i++) {
            
                for (int j = 0; ; j++) {
                    
                  if (j == n) return i;     // j - 1 的时候已经配对成功
                    
                  if (i + j == h) return -1;    // 刚刚出界 
                
                  if ( needle.charAt(j) != haystack.charAt(i + j) ) break;
                  //  逐個逐個字母比，有一個不樣，彈出                
                }
        }
    }
}

