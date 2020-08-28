class Solution {
     
        public int maxSumAfterPartitioning(int[] A, int K) {

            int[] memo = new int[A.length]; /** make an memo[] withe length = A.length **/

            memo[0] = A[0];  /** initiate memo[0] as A[0] **/

            int initMax = A[0]; /** initiate the Max as A[0] **/

            for (int i = 1; i < K; ++i) {

                if (A[i] > initMax) {

                    initMax = A[i];
                }

                memo[i] = (i + 1) * initMax;
            }

            /** initiate the first 3 elements in memo[]  **/

            /**         A = [ 1,15,7,9,2,5,10 ]
             *     memo[] = [ 1 30 45 0 0 0 0 ]
             *  **/

            /** Traverse all the elements **/
            for (int i = K; i < A.length; ++i) {

                int cur = 0;

                int M = A[i]; /** find the Max value in the partition */
                
                for (int j = 1; j <= K; ++j) {

                    if (A[i - j + 1] > M)  M = A[i - j + 1]; /** always get the largest element **/

                    cur = memo[i - j] + j * M;  /** previous memo[] value + current partition summary **/
                    if (cur > memo[i])  memo[i] = cur;  /** update the memo[i] within the partition loop  **/
                }
            }
            return memo[A.length - 1];
        }
}
