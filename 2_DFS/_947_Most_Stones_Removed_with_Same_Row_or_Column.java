class Solution {
   
        public int removeStones(int[][] stones) {
            
            boolean[][] visited = new boolean[10001][10001];
            
            int res = 0;
            
            for (int[] stone : stones) {
                
                int x = stone[0], y = stone[1];
                
                if ( !visited[x][y] ) res += dfs(stones, x, y, visited);
                
            }
            
            return res;
        }

        private int dfs(int[][] stones, int x, int y, boolean[][] visited) {
            
            if (visited[x][y]) return 0;
            visited[x][y] = true;
            
            int res_sub = 0;
            
            for (int[] stone : stones) {
                
                int nextX = stone[0], nextY = stone[1];
                
                if (visited[nextX][nextY]) continue;
                
                if (x == nextX) res_sub += 1 + dfs(stones, nextX, nextY, visited);
                if (y == nextY) res_sub += 1 + dfs(stones, nextX, nextY, visited);
                
            }
            
            return res_sub;
        }
  
}
