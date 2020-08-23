public class Solution {
 
    int[] union; // union find set

    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix

    public void solve(char[][] board) {
 
        if(board.length == 0 || board[0].length == 0) return;

        int height = board.length;
        int width = board[0].length;
  
        union = new int[height * width];
        hasEdgeO = new boolean[height * width];
  
        /** 赋值 union**/
        for(int i = 0;i<union.length; i++) union[i] = i;
  
        /** 赋值 hasEdgeO **/        
        for(int i = 0;i<hasEdgeO.length; i++){
            
            int x = i / width;
            int y = i % width;
            
            hasEdgeO[i] = ( board[x][y] == 'O' && (x==0 || x==height-1 || y==0 || y==width-1) ); 
        }

        /** 把元素，和，右边+上面，合并 | 或者 --> 是 左边+下边，合并 --> 都是一样的!!! --> 先进行大合并! **/
        for(int i = 0;i<union.length; i++){
            
            int x = i / width;
            int y = i % width; 
            
            int up = x + 1;     // 下
            int right = y - 1;  // 左
            
            /** 融合上一个 **/
            if(up < height && board[x][y] == board[up][y])           union(i,  i+width);
            
            /** 融合右边 **/
            if(right >= 0 && board[x][y] == board[x][right])         union(i,  i-1);
        }
 
        /** 如果 O 位置，不接壤边界，就变成 X **/
        for(int i = 0;i<union.length; i++){
            
            int x = i / width, y = i % width;
            
            if( board[x][y] == 'O' && !hasEdgeO[ findSet(i) ] )    board[x][y] = 'X'; 
            
        }
    }

    /** Union **/
    private void union(int x,int y){
        
        int rootX = findSet(x);
        int rootY = findSet(y);
       
        boolean a = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
         
        this.hasEdgeO[rootX] = a;  /** 这里解释一下，其实，只需要更新rootX (更新一个就行!!) 的位置就行，rootX在Union之后，会通过union指到rootY的位置，让hasEdgeO来查看 **/
        this.hasEdgeO[rootY] = a;
        
        union[rootY] = rootX;  // 让 x 跟随 y
        
    }

    /** Find **/
    private int findSet(int x){
        
        if(union[x] == x) return x;
        
        union[x] = findSet(union[x]);  // 每次查找，都会更新 union[x] 的值
        
        return union[x];
        
    }
}