class Solution {

        public List<Integer> pancakeSort(int[] A) {

            /** 制造答案 */
            List<Integer> res = new ArrayList<>();

            /** 下一个最大值 */
            for (int x = A.length; x > 0; --x) {

                    int i;

                    /** 找到下一个最大值的，index */
                    for (i = 0; A[i] != x; ++i) ;

                    /** 翻转 （i + 1），其实就是从到i的位置，只不过题目要给翻转的数目 */
                    reverse(A, i + 1);

                    /** 加入翻转的数字 */
                    res.add(i + 1);

                    /** 整体翻转一下 */
                    reverse(A, x);

                    /** 加入翻转的数字 */
                    res.add(x);
            }

            return res;
        }

        /** 翻转, 这里k是翻转的长度 */
        public void reverse(int[] A, int k) {
            for (int i = 0, j = k - 1; i < j; i++, j--) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
}

/**
 *  https://leetcode.com/problems/pancake-sorting/discuss/214213/JavaC%2B%2BPython-Straight-Forward
 *
 *  逻辑
 *  1. Find the index i of the next maximum number x.
 *  2. Reverse i + 1 numbers, so that the x will be at A[0]
 *  3. Reverse x numbers, so that x will be at A[x - 1].
 *  4. Repeat this process N times.
 *
 * */

