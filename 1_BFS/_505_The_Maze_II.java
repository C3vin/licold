public class Solution {
    
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        
        /** 制造distance的矩阵 **/
        int[][] distance = new int[maze.length][maze[0].length];
        
        /** 矩阵里面每个元素赋值为最大值 **/
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        /** 初始位置的距离为0 **/
        distance[start[0]][start[1]] = 0;
        
        /** 开始DFS **/
        dfs(maze, start, distance);
        
        /** 返回终点的值 **/
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    
    /** DFS内核 **/
    public void dfs(int[][] maze, int[] start, int[][] distance) {
        
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        
        /** 四个方向来一下 **/
        for (int[] dir: dirs) {
            
            /** count加一 **/
            int count = 0;
            
            /** 确定下一步的点 **/
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            
            /** 只要没有越界，就往前走一步 **/
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            
                /** 并且加一 **/
                count++;
            }
            
            /**  **/
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                
                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
            }
            
        }
    }
}