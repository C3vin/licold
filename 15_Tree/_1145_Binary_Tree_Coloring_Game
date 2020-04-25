class Solution {

        int left, right, val;

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

            /** 算出 val */
            val = x;

            /** 算出 left 和 right */
            count(root);

            return Math.max(    Math.max(left, right) /** 霸占一个最大的子女 */ ,    n - left - right - 1 /** 红色玩家能掌控的子女 */   )    >   n / 2 /** 是否能确保赢 */ ;

        }

        /** 找出一共有多少node */
        private int count(TreeNode node) {

            if (node == null) return 0;

            int l = count(node.left), r = count(node.right);

            if (node.val == val) {

                left = l;

                right = r;

            }

            return l + r + 1;
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
