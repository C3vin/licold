class Solution {
    
    public String minWindow(String s, String t) {
        
            /** 1. 邊界條件  **/
            if (s.length() == 0 || t.length() == 0) return "";

            /** 2. 製造字典（計算 t裡面的 字母）  **/
            Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        
            for (int i = 0; i < t.length(); i++) {
                
                int count = dictT.getOrDefault(t.charAt(i), 0);
                
                dictT.put(t.charAt(i), count + 1);
            }

            /** 3. 總共需要present的字母個數， unique 的 **/
            int required = dictT.size();

            /** 4. 左右 pointer  **/
            int l = 0, r = 0;

            /** 5. 重點，這個要看懂！ --> formed is used to keep track of how many unique characters in t are present in the current window in its desired frequency. e.g. if t is "AABC" then the window must have two A's, one B and one C. Thus formed would be = 3 when all these conditions are met. **/
            int formed = 0;

            /** 6. 製造字典 - 當前 windows 的 unique 字母 分別的個數  */
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            /** 7. ans list of the form (window length, left, right) */
            int[] ans = {-1, 0, 0};

            /** 8. 開始戰鬥，遍歷 s  **/
                while (r < s.length()) {

                    /** 8.1 從右邊，加一個字母  **/
                    char c = s.charAt(r);

                    /** 8.2 更新WindowsCounts **/
                    int count = windowCounts.getOrDefault(c, 0);

                    /** 8.3 更新WindowsCounts **/
                    windowCounts.put(c, count + 1);

                    /** 8.4 如果 t 其中一個字母的frequency，已經滿足，那麼 formed 加一  **/

                    if ( dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue() ) {
                        formed++;
                    }

                    /** 8.4 全部找到，嘗試從左邊，壓縮窗子 */
                    // Try and contract the window till the point where it ceases to be 'desirable'.
                    while (l <= r && formed == required) {

                                    /** ~1. 拿到最左邊的字母  **/
                                    c = s.charAt(l);

                                    /** ~2. 更新到，目前最小的 window  -->  ans = {-1, 0, 0};  **/
                                    if (ans[0] == -1 || r - l + 1 < ans[0]) {

                                        ans[0] = r - l + 1;

                                        ans[1] = l;

                                        ans[2] = r;
                                    }

                                    /** ~3. 移除，最左邊的字母 c   **/
                                    windowCounts.put(c, windowCounts.get(c) - 1);

                                    /** ~4. 如果 t 包含 c  -->  看是否觸動了 formed  **/
                                    if ( dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                                        formed--;
                                    }

                                    // Move the left pointer ahead, this would help to look for a new window.
                                    l++;
                    }

                    // Keep expanding the window once we are done contracting.
                    
                    r++;
            }

            /** 9. 如果這個window存在，從 s 裡面剪出這個 windows  **/
        
            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}