class Solution {
    
    public static List<String> commonChars(String[] A) {

        /** 1. 製造答案集 **/
        List<String> ans = new ArrayList<>();

        /** 2. 製造count，放26個字母  **/
        int[] count = new int[26];

        /** 3. count都放最大值  **/
        Arrays.fill(count, Integer.MAX_VALUE);

        /** 4. 遍歷  **/
        for (String str : A) {

            /**  ~1 製造 坑位**/
            int[] cnt = new int[26];

            /**  ~2 填坑 **/
            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.

            /** ~3 遍歷 26 --> 拿出最少次的重複 **/
            for (int i = 0; i < 26; ++i) { count[i] = Math.min( cnt[i], count[i] ); } // update minimum frequency.
        }

        /** 5. 拿出一直存在的字母  **/
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { ans.add("" + c); }
        }

        return ans;
    }
    
}