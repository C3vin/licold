class Solution {
 
        public int oddEvenJumps(int[] A) {   // https://youtu.be/Z-MjnodQH3w?t=71 

            int N = A.length;
            if (N <= 1) return N;

            /** 1. 定義，奇數跳，和，偶數跳   的 結果集 **/
            boolean[] odd = new boolean[N];
            boolean[] even = new boolean[N];

            /** 2. 最後一個元素，是終點，自動True **/
            odd[N-1] = even[N-1] = true;

            /** 3. 製造 TreeMap --> (元素的大小，index的位置) **/
            TreeMap<Integer, Integer> vals = new TreeMap();

            /** 4. A 數組的元素值，指向他的index **/
            vals.put(A[N-1], N-1);

            /** 5. 從倒數第2個開始算，一個一個位置的去算 odd 和 even 的 boolean值   **/
            for (int i = N-2; i >= 0; --i) {

                /** 5.1 A[i]的值，賦給 v  **/
                int v = A[i];

                /** 5.2 如果TreeMap --> vals 包括 v  --> 已經知道 **/
                if (vals.containsKey(v)) {

                    /** ~1 填充 odd[i] 和 even[i]  **/
                    odd[i] = even[vals.get(v)];
                    even[i] = odd[vals.get(v)];

                /** 5.3 否則  **/
                } else {

                    /** ~1 用TreeMap來拿小於 v 的最大數 **/
                    Integer lower = vals.lowerKey(v);

                    /** ~2 用TreeMap來拿大於 v 的最小數 **/
                    Integer higher = vals.higherKey(v);

                    /** ~3 填充 odd[i] 和 even[i]   -->  比如：如果lower等於null，就不會進行下一步 **/
                    if (lower != null)
                        even[i] = odd[vals.get(lower)];
                    if (higher != null) {
                        odd[i] = even[vals.get(higher)];
                    }
                }
 
                vals.put(v, i);
            }

            int ans = 0;

            for (boolean b: odd)
                if (b) ans++;

            return ans;
        }
    }
