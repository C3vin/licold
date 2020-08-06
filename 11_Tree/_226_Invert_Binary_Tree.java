class Solution {
    public TreeNode invertTree(TreeNode root) {

            /** Conner Case */
            if (root == null) {
                return null;
            }

            /** Recurrsion */
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);

            root.left = right;
            root.right = left;

            return root;
        } 
}