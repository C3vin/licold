class Solution {

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) return;

        int m = board.length, n = board[0].length;
 
        // 遍历所有的元素
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int lives = liveNeighbors(board, m, n, i, j);    /**算出活的生命個數**/

                /**    In the beginning, every 2nd bit is 0; So we only need to care about when will the 2nd bit become 1.   **/
                if ( board[i][j] == 1 &&  (lives == 2 || lives == 3) ) {
                     board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >> = 1;  // Get the 2nd state.
            }
        }
    }
 
    public static int liveNeighbors(int[][] board, int m, int n, int i, int j) {

        int lives = 0;

        for (int x = Math.max(i - 1, 0); /** 從上一排開始算 **/ x <= Math.min(i + 1, m - 1); /** 算到下一排，但不超過總排数 **/ x++) {

                for (int y = Math.max(j - 1, 0); /** 從左一列開始算 **/ y <= Math.min(j + 1, n - 1);  /** 但不超過列的長度 **/ y++) {

                    lives += board[x][y] & 1;  /** 看是否活著 **/

                }

        }

        lives -= board[i][j] & 1;  /** 減去自己，得出周圍的生命 **/
        
        return lives;
    }
}