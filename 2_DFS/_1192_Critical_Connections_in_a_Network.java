class Solution {
     
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(List<Integer> con :connections) {
            
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        
        int timer[] = new int[1];   
        // Integer timer = 0; --> 也可以，但消耗大 --> Wrapper Class是immutable的
        // int timer = 0; -->  也可以，我糊涂了，到底哪个好
        
        List<List<Integer>> results = new ArrayList<>();
        
        boolean[] visited = new boolean[n];
        
        int[] count = new int[n]; // time counter 
        
        dfs(graph, -1, 0, timer, visited, results, count);
        
        return results;
    }
    
    
    public void dfs(List<Integer>[] graph, int parent, int node, int timer[], boolean[] visited, List<List<Integer>> results, int []count) {
        
        visited[node] = true;
        
        count[node] = timer[0]++;  // Timer就是计时器
        
        int curr = count[node];
        
        for(int nei : graph[node]) {
            
            if(nei == parent) continue;
            
            if(!visited[nei]) dfs(graph, node, nei, timer, visited, results, count);
            
            count[node] = Math.min(count[node], count[nei]);
            
            if(curr < count[nei]) results.add(Arrays.asList(node, nei));
        }
        
        
    }
    
}