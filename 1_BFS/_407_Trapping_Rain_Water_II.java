class Solution {
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int trapRainWater(int[][] heightMap) {
        
        if(heightMap==null||heightMap.length<3||heightMap[0].length<3) {
            return 0;
        }
        
        int rowLen = heightMap.length;
        int colLen = heightMap[0].length;
        boolean[][] visited = new boolean [rowLen][colLen];//false
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)->a.height-b.height);
        
        int res =0;
        
        for(int row=0;row<rowLen;row++){
            addCell(row,0,heightMap,visited,pq);
            addCell(row,colLen-1,heightMap,visited,pq);
        }
        
        for(int col=1;col<colLen-1;col++){
            addCell(0,col,heightMap,visited,pq);
            addCell(rowLen-1,col,heightMap,visited,pq);
        }
        
        int M = 0;  // max popped Heap Value
        
        while(!pq.isEmpty()){  // 每次弹出
            
            Cell cell = pq.poll();
            
            M = Math.max(cell.height, M); 
            
            for(int[] dir : dirs){
                
                int neiRow = cell.row+dir[0];
                int neiCol = cell.col + dir[1];
                 
                if(neiRow>=1&&neiRow<rowLen-1&&neiCol>=1&&neiCol<colLen-1){
                    
                    if(!visited[neiRow][neiCol]){
                        
                        visited[neiRow][neiCol] = true;
                        
                        int currH = heightMap[neiRow][neiCol]; 
                        
                        int water = M - currH; 
                        
                        if(water > 0) res += water; 
                       
                        pq.offer( new Cell(neiRow,neiCol,currH));
                    }
                }
            }
        }
        
        return res;
    }
    
    private void addCell(int row,int col,int[][] heightMap,boolean[][]visited,PriorityQueue<Cell> pq ){
        Cell cell = new Cell(row,col,heightMap[row][col]);
        pq.offer(cell);
        visited[row][col]=true;
    }
    
    static class Cell{
        int row;
        int col;
        int height;
        Cell(int row,int col, int height){
            this.row=row;
            this.col = col;
            this.height = height;
        }
    }
}