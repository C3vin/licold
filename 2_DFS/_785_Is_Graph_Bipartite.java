class Solution {
    
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int[] colors = new int[n]; // two colors, 1 and -1	
				
        for (int i = 0; i < n; i++) {  //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, i, -1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int node, int color) {
        
        if (colors[node] != 0) {
            return colors[node] == color;
        }       
        
        colors[node] = color;     
        
        for (int next : graph[node]) {
            
            if (!validColor(graph, colors, next, -color)) {
                
                return false;
            }
        }
        return true;
    }
}