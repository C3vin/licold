class Solution {
    
     public int repeatedStringMatch(String A, String B) {

            int q = 1;

            StringBuilder S = new StringBuilder(A);

            /** 先 讓 A 比 B 長 */
            for (; S.length() < B.length(); q++) S.append(A);

            if (S.indexOf(B) >= 0) return q;

            if (S.append(A).indexOf(B) >= 0) return q+1;

            return -1;

        }
    
}