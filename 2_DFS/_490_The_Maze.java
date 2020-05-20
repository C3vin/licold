class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        return helper(maze, start, destination, visited, dirs);
    }

    public boolean helper(int[][] maze, int[] start, int[] destination, boolean[][] visited, int[][] dirs) {

        if (visited[start[0]][start[1]]) return false;

        visited[start[0]][start[1]] = true;

        if (start[0] == destination[0] && start[1] == destination[1]) return true;

        int X;  int Y;
        boolean flag;

        for (int[] dir: dirs) {

            X = start[0] + dir[0];     Y = start[1] + dir[1];

            while (X >= 0 && X < maze.length && Y >= 0 && Y < maze[0].length && maze[X][Y] == 0) {
                X += dir[0];     Y += dir[1];
            }

            flag = helper(maze, new int[] {X-dir[0], Y-dir[1]}, destination, visited, dirs); 
			
            if (flag) return true;
        }
        return false;
    }
}