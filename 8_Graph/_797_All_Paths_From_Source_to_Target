class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        if (graph == null || graph.length == 0) {
            return null;
        }
        
        List<Integer> currPath = new ArrayList<>(); // 当前路径
        List<List<Integer>> res = new ArrayList<>(); // return result
        
        currPath.add(0); //起点
        
        backtrack(graph, 0, graph.length - 1, currPath, res);
        
        return res;
    }
    
    private void backtrack(int[][] graph, 
                           int start, 
                           int end, 
                           List<Integer> currPath, 
                           List<List<Integer>> res) {
        if (start == end) {
            //当前路径圆满
            res.add(new ArrayList<>(currPath));
            return;
        }
        
        //backtrack套路
        for (int nei : graph[start]) {
            
            currPath.add(nei);
            
            backtrack(graph, nei, end, currPath, res);
            
            currPath.remove(currPath.size() - 1);
            
        }
    }
}