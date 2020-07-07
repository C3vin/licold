class Solution {
    
    boolean[][] p;
    boolean[][] a;
    boolean[][] visited;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(matrix.length == 0) return ans;
        
        int rows = matrix.length, columns = matrix[0].length;
        
        p = new boolean[rows][columns];
        a = new boolean[rows][columns];
        
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        
        for(int i = 0; i < rows; i++){
            
            p[i][0] = true;              pq.offer(new int[]{i, 0});
            a[i][columns-1] = true;      aq.offer(new int[]{i, columns-1});
        }
        
        for(int i = 0; i < columns; i++){
            
            p[0][i] = true;             pq.offer(new int[]{0, i});
            a[rows-1][i] = true;        aq.offer(new int[]{rows-1, i});
        }
  
        bfs(matrix, p, pq, rows, columns);
        bfs(matrix, a, aq, rows, columns);
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                
                if(p[r][c] && a[r][c]){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(r);
                    tmp.add(c);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }
    
    public void bfs(int[][] matrix, boolean[][] ocean, Queue<int[]> q, int rows, int columns){
        
        int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};
        
        int nr, nc;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                
                int[] cur = q.poll();
                
                for(int j = 0; j < 4; j++){
                    
                    nr = cur[0] + dr[j];
                    nc = cur[1] + dc[j];
                    
                    if(0<=nr && nr<rows && 0<=nc && nc<columns && matrix[nr][nc] >= matrix[cur[0]][cur[1]] && !ocean[nr][nc]){
                        
                        ocean[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}