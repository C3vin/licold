public class Solution {
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        Map<Integer, List<Integer>> res = new HashMap<>(); 
          
        dfs(root, res);
        
        return new ArrayList<>(res.values());
        
    }
    
    private int dfs(TreeNode node, Map<Integer, List<Integer>> res){
        
        if(null==node)  return 0;
     
        int level = 1 + Math.max( dfs(node.left, res), dfs(node.right, res) );
     
        res.putIfAbsent(level, new ArrayList<>()); 
        
        res.get(level).add(node.val);
         
        return level;
    }
}
