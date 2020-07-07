class Solution {
    
    public static final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    
    private char count(char[][] board, int x, int y) {
        
        int count = 0, m = board.length, n = board[0].length;
   
         for(int[] dir:dirs){
                
                int i = dir[0]+x; 
                int j = dir[1]+y;
                
                if( i>=0 && i<m && j>=0 && j<n ) {
                        if (board[i][j] == 'M') {
                            count++;
                        }
                }
        }
        
        return count > 0 ? (char)(count + '0') : 'B';
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        int m = board.length, n = board[0].length;
       
        Queue<int[]> q = new LinkedList<>();
        q.offer(click);
        
        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            
            board[cur[0]][cur[1]] = count(board, cur[0], cur[1]);
            
            if (board[cur[0]][cur[1]] != 'B') continue;
            
            for(int[] dir:dirs){
                
                int i = dir[0]+cur[0]; 
                int j = dir[1]+cur[1];
                
                if( i>=0 && i<m && j>=0 && j<n ) {
                    
                     if (board[i][j] == 'E') {
                         
                        board[i][j] = count(board, i, j);
                         
                        if (board[i][j] != 'B') continue;
                         
                        q.offer(new int[] {i, j});
                    
                       }
                   }
            }
        }
        return board;
    }
}

 
 
    
    


