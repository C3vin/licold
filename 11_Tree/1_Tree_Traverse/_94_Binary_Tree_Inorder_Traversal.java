// Iterative
class Solution {
 
   public List<Integer> inorderTraversal(TreeNode root) {
       
        List<Integer> list = new LinkedList<>();
       
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
       
        while (root != null || !stack.isEmpty()) {
            
            if (root != null) {  
                
                stack.addFirst(root);
                root = root.left;  
                
            } else {       
                
                TreeNode curr = stack.removeFirst(); 
                
                list.add(curr.val);
                
                root = curr.right;
            }
        }
       
        return list;
    }
}

///////////////////////////

// Recursive
class Solution {
 
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new LinkedList<Integer>();
        
        dfs(root, res); 
    
        return res;
    }
    
    
    public void dfs(TreeNode root, List<Integer> res){
        
        if(root == null) return;
        
        dfs(root.left, res); 
        
        res.add(root.val); 
        
        dfs(root.right,res); 
        
    }
  
}








