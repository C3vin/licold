class Solution {
   
        public String reorganizeString(String S) {

            /** 1. 初始化 參數 **/
            int N = S.length();
            int[] count = new int[26];

            /** 2. 出現一次，就踩點 **/
            for (char c : S.toCharArray()) count[c - 'a']++;

            /** 3.  如果count相同，就用letter排序 | 逆序排count，正序排字母 **/
            PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>( (a, b) -> a.count == b.count ? a.letter - b.letter : b.count - a.count );

            /** 4. 遍歷 count **/
            for (int i = 0; i < 26; ++i) {

                /** 如果 被 踩過，就大於0 **/
                if (count[i] > 0) {

                    /** ~1 如果踩的次數，大於中位數，永遠返回 零 **/
                    if (count[i] > (N + 1) / 2) return "";

                    /** ~2 加入 PQ  **/
                    pq.add(new MultiChar(count[i], (char) ('a' + i)));
                }
            }

            /** 5. 建造答案  **/
            StringBuilder ans = new StringBuilder();

            /** 6. 只要容量大於 2  **/
            while (pq.size() >= 2) {

                MultiChar mc1 = pq.poll();
                MultiChar mc2 = pq.poll();

            /*This code turns out to be superfluous, but explains what is happening
            if (ans.length() == 0 || mc1.letter != ans.charAt(ans.length() - 1)) {
                ans.append(mc1.letter);
                ans.append(mc2.letter);
            } else {
                ans.append(mc2.letter);
                ans.append(mc1.letter);
            }*/

                /** ~1 交錯放字母  **/
                ans.append(mc1.letter);
                ans.append(mc2.letter);

                if (--mc1.count > 0) pq.add(mc1);
                if (--mc2.count > 0) pq.add(mc2);
            }


            /** 放下剩餘的 **/
            if (pq.size() > 0) ans.append(pq.poll().letter);

            return ans.toString();
        }


        /** 定義 MultiChar **/
        static class MultiChar {

            int count;
            char letter;

            MultiChar(int ct, char ch) {
                count = ct;
                letter = ch;
            }
        }
}
