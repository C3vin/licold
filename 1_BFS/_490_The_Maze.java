class Solution {
   
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
    
        int dirs[] = {-1, 0, 1, 0, -1};
        int n = maze.length;
        int m = maze[0].length;
    
        Queue<int[]> q = new LinkedList<>();
    
        q.add(start);
    
        maze[start[0]][start[1]] = -1997;
    
        while (!q.isEmpty()) {
            
            int[] curr = q.poll();
            
            for (int i = 1; i < dirs.length; i++) {
                
                    int x = curr[0], y = curr[1];

                    while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != 1) {
                        x += dirs[i - 1];
                        y += dirs[i];
                    }

                    x -= dirs[i - 1];
                    y -= dirs[i];

                    if (x == dest[0] && y == dest[1]) return true;

                    if (maze[x][y] == 0) {
                        maze[x][y] = -1997;
                        q.add(new int[]{x, y});
                    }
            }
        }
        return false;
    }
}