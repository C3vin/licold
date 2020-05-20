public class Solution {

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
 
        int[][] distance = new int[maze.length][maze[0].length];  /** 制造distance的矩阵 **/
 
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);  /** 矩阵里面每个元素赋值为最大值 **/
        
        distance[start[0]][start[1]] = 0;  /** 初始位置的距离为0 **/
		
		int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
       
        dfs(maze, start, distance, dirs);   /** 开始DFS **/
       
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];   /** 返回终点的值 **/
    } 
  
    public void dfs(int[][] maze, int[] start, int[][] distance, int[][] dirs) {  /** DFS内核 **/
  
        for (int[] dir: dirs) {  /** 四个方向来一下 **/

            /** count加一 **/
            int count = 0;

            /** 确定下一步的点 **/
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];

            /** 只要没有越界，就往前走一步 **/
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];

                count++; /** 并且加一 **/
            }

			int curDis = distance[start[0]][start[1]] + count;
 
            if (curDis< distance[x - dir[0]][y - dir[1]]) {

                distance[x - dir[0]][y - dir[1]] = curDis;

                dfs(maze, new int[] { x - dir[0], y - dir[1] }, distance, dirs);
            }
        }
    }
}