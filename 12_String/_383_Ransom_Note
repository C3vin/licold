class Solution {
    
	// 题目意思 https://www.youtube.com/watch?v=cEqDrgECmX0 
	
    public boolean canConstruct(String ransomNote, String magazine) {
        
            int[] arr = new int[26];

            /** let b 's element ++  */
            for (int i = 0; i < magazine.length(); i++) {
                arr[magazine.charAt(i) - 'a']++;
            }

            /** check all */
            for (int i = 0; i < ransomNote.length(); i++) {
                if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                    return false;
                }
            }

            return true;
    }
    
}