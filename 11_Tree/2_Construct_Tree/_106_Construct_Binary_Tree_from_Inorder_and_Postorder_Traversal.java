 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
        if(inorder == null || inorder.length == 0) return null; 
        
        int len = inorder.length; 
        
        Map<Integer, Integer> inMap = new HashMap<>(); 
        
        for(int i = 0; i < len; i++){
        
                inMap.put( inorder[i], i ); 
        }
        
        return helper(
                      inorder,   0, len - 1, 
                      postorder, 0, len - 1,
                      inMap
                     );
        
    }
 
    public TreeNode helper(
                            int[] in, int inStart, int inEnd, 
                            int[] po, int poStart, int poEnd,
                            Map<Integer, Integer> inMap
                          )
    {
        
        if( inStart > inEnd || poStart > poEnd ) return null; 
        
        int rootVal = po[poEnd]; 
         
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inMap.get(rootVal); 
        
        int rightRange = inEnd - rootIndex; 
 
        root.left = helper(
                            in, 0, rootIndex - 1, 
                            po, poStart, poEnd - rightRange - 1,  
                            inMap
                            );

        root.right = helper(
                            in, rootIndex + 1, inEnd, 
                            po, poEnd - rightRange, poEnd - 1, 
                            inMap
                            );
        return root; 
    }
}