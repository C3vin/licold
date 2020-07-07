/** 題目意思 https://www.youtube.com/watch?v=0psTRx1FxPQ  **/

class Solution {

        public int snakesAndLadders(int[][] board) {

            /** 边界条件 */
            if (board == null || board.length == 0)
                return 0;

            int n = board.length;

            boolean[] visited = new boolean[n * n + 1];

            /** 制造queue */
            Queue<Integer> q = new ArrayDeque<>();

            /** 把第一个元素加进去 */
            q.offer(1);

            int moves = 0;
            int min = n * n;

            /** 开始BFS */
            while (!q.isEmpty()) {

                int size = q.size();

                for (int i = 0; i < size; i++) {

                                int cur = q.poll();

                                /** 更新moves */
                                if (cur == n * n) {
                                    min = Math.min(min, moves);
                                }

                                for (int j = 1; j <= 6; j++) {

                                        if (j + cur > n * n) break;

                                        if (!visited[j + cur]) {

                                                    visited[j + cur] = true;

                                                    /** 获得行列信息 */
                                                    int row = n - (j + cur - 1) / n - 1;
                                                    int col = ((n - row) % 2 != 0) ? (j + cur - 1) % n : n - (j + cur - 1) % n - 1;

                                                    /** 假如他有循环的话, 就跳过这个可能 */
                                                    if (board[row][col] == cur) continue;

                                                    if (board[row][col] == -1) {

                                                        q.offer(j + cur);

                                                    } else {

                                                        q.offer(board[row][col]);
                                                    }
                                        }
                                }
                }

                /** 说明有一个大的move */
                moves++;
            }

            /** 其实就算没有捷径，也只是 n*n - 1 步骤 */
            return min == n * n ? -1 : min;
        }
    
}