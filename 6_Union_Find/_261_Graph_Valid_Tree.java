public class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        
        // initialize n isolated islands
        int[] fathers = new int[n];
        Arrays.fill(fathers, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            
            int x = find(fathers, edges[i][0]);
            int y = find(fathers, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            fathers[y] = x;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int fathers[], int i) {
        
        if (fathers[i] == -1) return i;
        
        return find(fathers, fathers[i]);
    }
    
}