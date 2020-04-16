class Solution {

        /** https://youtu.be/VwqOURrN2uo?t=86  |  自己录音了 */
    
        int steps;

        public int distributeCoins(TreeNode root) {

            steps = 0;

            dfs(root);

            return steps;
        }

        public int dfs(TreeNode node) {

            if (node == null) return 0;

            int L = dfs(node.left);
            int R = dfs(node.right);

            steps += Math.abs(L) + Math.abs(R);

            return node.val + L + R - 1;
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