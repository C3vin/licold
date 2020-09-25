class Solution {
    
  public int numIslands(char[][] grid) {
      
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
      
    int num_islands = 0;

    for (int r = 0; r < nr; ++r) {
        
      for (int c = 0; c < nc; ++c) {
          
            if (grid[r][c] == '1') {

                      ++num_islands;
                      grid[r][c] = '0'; // mark as visited

                      Queue<Integer> neighbors = new LinkedList<>();
                      neighbors.add(r * nc + c);

                      while (!neighbors.isEmpty()) {

                            int id = neighbors.poll();
                          
                            int row = id / nc;
                            int col = id % nc;

                            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                              neighbors.add((row-1) * nc + col);
                              grid[row-1][col] = '0';
                            }

                            if (row + 1 < nr && grid[row+1][col] == '1') {
                              neighbors.add((row+1) * nc + col);
                              grid[row+1][col] = '0';
                            }

                            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                              neighbors.add(row * nc + col-1);
                              grid[row][col-1] = '0';
                            }

                            if (col + 1 < nc && grid[row][col+1] == '1') {
                              neighbors.add(row * nc + col+1);
                              grid[row][col+1] = '0';
                            }
                      }
                }
      }
    }
    return num_islands;
  }
}

//////////////////////////////////////////////////////////////////////  0921 BFS 
/////教训:  应该在入队之前标记visited，不然会重复入队； 
class Solution {
    
    int count = 0; 
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; 
    
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0) return 0; 
        
        int r = grid.length; 
        int c = grid[0].length; 
         
        for(int m = 0; m < r; m++)
            for(int n = 0; n < c; n++) 
                    if(  grid[m][n] == '1' ) {
                       
                        count++; 
                        
                        bfs(grid, m, n, r, c); 
                    }   
        
        return count; 
    }
    
    public void bfs(char[][] grid, int i, int j, int r, int c) {
        
        Queue<int[]> q = new LinkedList<int[]>(); 
        
        q.add(new int[]{i,j}); 
        
        grid[ i ][ j ] = '0'; 
      
        while(!q.isEmpty()){
            
                int[] curr = q.poll(); 
             
                grid[ curr[0] ][ curr[1] ] = '0'; 
 
                for(int[] dir : dirs) {

                    int ii = curr[0] + dir[0]; 
                    int jj = curr[1] + dir[1];

                    if( ii>=0 && ii < r && jj>=0 && jj < c && grid[ii][jj] == '1' ){
                        
                        q.add(new int[]{ii,jj}); 
                        grid[ii][jj] = '0';
                    }
                } 
        }        
    }    
}
