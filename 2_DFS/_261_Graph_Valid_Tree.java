public class Solution {
    
    public boolean validTree(int n, int[][] edges) {
         
		// build the graph
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
		// build the visited 
        boolean[] visited = new boolean[n];
        
        // make sure there's no cycle
        if (hasCycle(adjList, visited, 0, -1))
            return false;
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        
        return true;
    }
    
    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int u, int parent) {
		
        visited[u] = true;
        
		// Get adjacent nodes 
        for (int i = 0; i < adjList.get(u).size(); i++) {
			
            int v = adjList.get(u).get(i);
            
			// parent != v  -->  because v is a node, and v's parent is also his adjacent
            if ( (visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, visited, v, u)) )
				return true;
        }
        
        return false;
    }
}