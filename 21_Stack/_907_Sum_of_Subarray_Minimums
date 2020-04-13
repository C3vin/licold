class Solution {
      
        // https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
    
        public int sumSubarrayMins(int[] A) {

            final int kMod = 1000000007;
            final int n = A.length;

            Stack<Integer> stack_Nums = new Stack<>();
            Stack<Integer> stack_Lens = new Stack<>();

            int[] left = new int[n];
            int[] right = new int[n];

            int ans = 0;

            /** 求 i 左邊的個數 **/
            for (int i = 0; i < n; ++i) {

                int len = 1;

                while (!stack_Nums.empty() && A[i] < stack_Nums.peek() )  {  len += stack_Lens.pop();   stack_Nums.pop(); }

                stack_Nums.push(A[i]);
                stack_Lens.push(len);

                left[i] = len;
            }

            /** 求 i 右邊的個數 **/
            stack_Nums.clear();
            stack_Lens.clear();

            for (int i = n - 1; i >= 0; --i) {
                int len = 1;
                while (!stack_Nums.empty() && A[i] <= stack_Nums.peek() ) {
                    len += stack_Lens.pop(); stack_Nums.pop();
                }
                stack_Nums.push(A[i]);
                stack_Lens.push(len);
                right[i] = len;
            }
 
            for (int i = 0; i < n; ++i)  /***/ ans = (int) (   ans + (long) A[i] * left[i] * right[i]   ) % kMod;

            return ans;
        }
}