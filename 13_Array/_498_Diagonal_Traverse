class Solution {

         public int[] findDiagonalOrder(int[][] matrix) {

             /** 1. 邊界條件 */
             if (matrix.length == 0) return new int[0];

             /** 2. 定義參數 */
             int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];

             /** 3. 遍歷所有的元素 */
             for (int i = 0; i < arr.length; i++) {

                 /** ～3.1 給 arr 賦值 */
                 arr[i] = matrix[r][c];

                 /** ～3.2 如果相加是偶數，往上的路線 */
                 if ((r + c) % 2 == 0) { // moving up

                     /** ～1 如果碰到右邊界 */
                     if (c == n - 1) {
                         r++;

                     /** ～2 如果是第一行 */
                     } else if (r == 0) {
                         c++;

                     /** ～3 如果是中間的話，往右上走 */
                     } else {
                         r--;
                         c++;
                     }

                 /** ～3.3 如果相加是奇數，往上的路線 */
                 } else {                // moving down
                     /** ～ 1 如果碰到底部，列數++ */
                     if (r == m - 1) {
                         c++;
                     /** ～ 2 如果碰到左邊界，行數++ */
                     } else if (c == 0) {
                         r++;
                     /** ～3 如果是中間的話，往左下走 */
                     } else {
                         r++;
                         c--;
                     }
                 }
             }
             return arr;  
        }
}