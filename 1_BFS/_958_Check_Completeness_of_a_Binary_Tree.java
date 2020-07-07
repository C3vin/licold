    
    /** Easy Way **/
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
    
    
/** Nick White **/
class Solution {
    
    public boolean isCompleteTree(TreeNode root) {
        
        if(root == null) return false; 
        
        if(root.left == null && root.right == null) return true; 
        
        boolean end = false; 
    
        Queue<TreeNode> Q = new LinkedList<TreeNode>(); 
        
        Q.add(root);
        
        while(!Q.isEmpty()){
            
            TreeNode curr = Q.poll(); 
            
            if(curr == null) end = true; 
            
            if(curr != null) {
                
                if(end) return false; 
                
                Q.add(curr.left); 
                Q.add(curr.right); 
   
            } 
     
        }
         
        return true; 
    }
}
    
