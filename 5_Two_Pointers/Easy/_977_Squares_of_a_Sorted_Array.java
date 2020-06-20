/** two pointer **/
class Solution {

    public int[] sortedSquares(int[] A) {

        /** 1. 拿到長度  **/
        int N = A.length;
        int j = 0;

        /** 2. 看到負數，就 j 增長1  **/
        while (j < N && A[j] < 0) j++;

        /** 3. 定義 i --> i是往左走，j是往右走 **/
        int i = j-1;

        /** 4. 定義結果集合  **/
        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            
            if (A[i] * A[i] < A[j] * A[j]) {
                
                ans[t++] = A[i] * A[i];
                i--;
                
            } else {
                
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }

        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
}