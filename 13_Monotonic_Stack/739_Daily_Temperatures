class Solution {

        public int[] dailyTemperatures(int[] T) {

            int[] M = new int[T.length];

            Stack<Integer> stack = new Stack();

           /***  {73, 74, 75, 71, 69, 72, 76, 73};  */

           for (int i = T.length - 1; i >= 0; --i) {

               /** 把單調棧，小於自己的，全部pop出來  **/
                while ( !stack.isEmpty() && T[i]  >=  T[ stack.peek() ] ) {

                    stack.pop();

                }

                M[i] = stack.isEmpty() ? 0 : stack.peek() - i;

                stack.push(i);
            }
            return M;
        }
}
