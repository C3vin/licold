class Solution {
      
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        Map<Integer, Integer> inMap = new HashMap<>(); 
         
        int len = inorder.length; 
          
        for(int i = 0; i < inorder.length; i++){
             
            inMap.put(inorder[i], i); 
        }
         
        TreeNode root = helper(preorder, 0, len - 1, inorder, 0, len - 1, inMap); 
          
        return root; 
    }
     
    
    public TreeNode helper(int[] pre, int preStart, int preEnd, 
                           int[] in, int inStart, int inEnd,
                           Map<Integer, Integer> inMap)
    {
     
        if(preStart > preEnd || inStart > inEnd) return null;  
         
        int val = pre[preStart]; 
          
        TreeNode root = new TreeNode( val); 
         
        int inPosition = inMap.get( val ); 
         
        int leftRange = inPosition - inStart; 
         
        root.left =  helper( pre, preStart + 1,              preStart + leftRange, 
                             in,  inStart,                   inPosition - 1, 
                             inMap
                           ); 
          
        root.right = helper( pre, preStart + leftRange + 1,   preEnd, 
                             in,  inPosition + 1,             inEnd, 
                             inMap
                           );         
         
        return root; 
    } 
} 