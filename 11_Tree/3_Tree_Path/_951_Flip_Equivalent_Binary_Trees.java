class Solution {
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null) return true; 
        
        if(root1 == null || root2 == null) return false;
        
        if( root1.val != root2.val ) return false; 
        
        int r1 = root1.left != null ? root1.left.val : -1;
        
        int r2 = root2.left != null ? root2.left.val : -1;
        
        if( r1 != r2 ){ // 如果不一样，就把 root1 左右调换。
            
            TreeNode t = root1.left;
            
            root1.left = root1.right;
            
            root1.right = t;
        }
        
        return flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
    }
}