class Solution {
    
     public int rangeSumBST(TreeNode root, int L, int R) {
     
        if (root == null) return 0; // base case.
     
        if (root.val < L) return rangeSumBST(root.right, L, R); // left branch excluded.
     
        if (root.val > R) return rangeSumBST(root.left, L, R); // right branch excluded.
     
        return root.val + rangeSumBST(root.right, root.val, R) + rangeSumBST(root.left, L, root.val); // count in both children.
     
    }
    
}
