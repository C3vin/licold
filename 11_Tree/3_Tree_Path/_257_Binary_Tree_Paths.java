class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
     
        LinkedList<String> paths = new LinkedList<String>(); 
        
        dfs(root, "", paths);
        
        return paths; 
    }
        
   public void dfs(TreeNode root, String path, List<String> paths){
        
        if(root == null) return; 
        
        path = path + Integer.toString(root.val);
       
        if(root.left == null && root.right == null) paths.add(path); 
        
        path = path + "->";
        
        dfs(root.left, path, paths);
        dfs(root.right, path, paths);  
        
    }     
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
