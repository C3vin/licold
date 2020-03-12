class Solution {
    
        /** DFS **/
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {

            ans = 1;
            depth(root);

            return ans - 1;
        }

        public int depth(TreeNode node) {

            if (node == null) return 0;

            int L = depth(node.left);
            int R = depth(node.right);

            ans = Math.max(ans, L+R+1);

            return Math.max(L, R) + 1;

        }


        /** MaxDepth **/
        int max = 0;

        public int diameterOfBinaryTree_2(TreeNode root) {
            maxDepth(root);
            return max;
        }

        private int maxDepth(TreeNode root) {

            if (root == null) return 0;

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            max = Math.max(max, left + right);

            return Math.max(left, right) + 1;
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
