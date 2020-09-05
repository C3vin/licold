class Solution {

        /* /** stack  |  O(n) O(n)  |  https://www.youtube.com/watch?v=KkJrGxuQtYo   **/ */
        
        public int largestRectangleArea(int[] heights) {

            /** 1. 邊界條件  **/
            if (heights == null || heights.length == 0) return 0;

            /** 2. 製造stack  **/
            Stack<Integer> stack = new Stack<>();

            /** 3. 制造 結果 **/
            int res = 0;

            /** 4. 遍歷 heights  **/
            for (int i = 0; i <= heights.length; i++) {

                        /** 4.1 如果到頂了，返回0；沒到頂，就返回當前高度  **/   /** 如果 h = 0, stack剩下的元素全部跑一遍**/
                        int h = i == heights.length ? 0 : heights[i];

                        /** 4.2 若stack不空，h < heights[stack.peek()]  |  從小到大排高度，中間有不一致的，彈出 **/
                        while (!stack.isEmpty() && h < heights[stack.peek()]) {
  
                                /** ~1 Pop() 當前stack的高度 height **/
                                int height = heights[stack.pop()];

                                /** ~2 找出左邊界 **/
                                int start = stack.isEmpty() ? -1 : stack.peek();

                                /** ~3 算出面積  **/
                                int area = height * (i - start - 1);

                                res = Math.max(res, area);
                        }

                        stack.push(i);

            }

            return res;
        }
    }
