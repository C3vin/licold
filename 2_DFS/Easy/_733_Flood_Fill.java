class Solution {
	
	int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
        int color = image[sr][sc];
		
        if (color != newColor) dfs(image, sr, sc, color, newColor);
		
        return image;
    }
	
    public void dfs( int[][] image, int r, int c, int color, int newColor ) {
		
		if( r<0 || c<0 || r==image.length || c==image[0].length[] || color == newColor) return; 
		
		image[r][c] = newColor;
		
		int X; 
		int Y; 
		int color; 
		
		for(int[] dir : dirs) {
			
			X = r + dir[0];
			Y = c + dir[1];
			color = image[X][Y];
			 
			dfs( int[][] image, int X, int Y, int color, int newColor ); 
		}
    }
}
