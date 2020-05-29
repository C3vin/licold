class Solution {
    
    public int countNodes(TreeNode root) {
    
        if(root == null) return 0;
        
        int left = getHeight(root, 1);
        int right = getHeight(root, 0);

        if(left == right) return ((2<<(left)) -1);
        
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }
    
    public int getHeight(TreeNode root, int leftOrRight){
         
        int count=0;
 
        if(leftOrRight==1){  // left
             while(root.left!=null){
                count++;
                root = root.left;
            }
        } else {            // right
            while(root.right!=null){
            count++;
            root = root.right;
            }
        }
        return count;
    }
}