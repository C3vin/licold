class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
 
        ArrayList < Integer > [] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList < Integer > ();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
        
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            
        } // build graph & root[];
        
        Boolean[] visited = new Boolean[numCourses];
        
        List < Integer > ans = new ArrayList < Integer > ();
   
          for (int i = 0; i < visited.length; i++) {
      
              if( visited[i] == null){
                if ( !dfs(i, graph, ans, visited) ) return new int[0];
            }
            
        }
        
        if (ans.size() != numCourses) return new int[0];
        
        int[] res = new int[ans.size()];
        
        int index = 0;
        
        for (int i: ans) {
            res[index++] = i;
        }
        
        return res;
    }
    
    public boolean dfs(int cur, ArrayList < Integer > [] graph, List < Integer > ans, Boolean[] visited) {
        
        if ( visited[cur] != null ) return visited[cur];   //  来判断是否有环!!!!!!!!!!!!!!!
        
        visited[cur] = false; // 这个课还没上过，但被检查过
        
        for (int c: graph[cur]) {   // 指望着 cur 的 课程
            if ( !dfs(c, graph, ans, visited) ) return false;
        }
        
        ans.add(0, cur);  // 最后再加上最开始的。
        
        visited[cur] = true;  // 这个课已经上了
        
        return true;
    }
}












