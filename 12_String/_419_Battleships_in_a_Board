class Solution {
    
    public int countBattleships(char[][] board) {

            /** 1 board 高度 */
            int m = board.length;
            if (m==0) return 0;

            /** 2 board 宽度 */
            int n = board[0].length;

            /** 3 初始化为 0 */
            int count=0;

            /** 4 遍历 */
            for (int i=0; i<m; i++) {  // 高
                
                for (int j=0; j<n; j++) {  // 宽 

                    /** ~ 1 如果只是"."，返回 */
                    if (board[i][j] == '.') continue;

                    /** ~2 如果不是"."，判断上面是否是"X"，如果是的，已经判断过了 --> 这里没有包括第一行 */
                    if (i > 0 && board[i-1][j] == 'X') continue;

                    /** ~3 判断左边是否是"X"，如果是的，已经判断过了 --> 这里没有包括第一列 */
                    if (j > 0 && board[i][j-1] == 'X') continue;

                    count++;
                }

                /**
                char[][] board = {
                                        {'X', '.', '.', 'X'},
                                        {'.', 'X', '.', 'X'},
                                        {'.', '.', '.', 'X'}
                };
                */
            }
            return count;
    }
}