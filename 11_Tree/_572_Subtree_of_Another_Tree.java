class Solution {
    
        /** 主函數 */
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return traverse(s, t);
        }

        /** 子函數 2 級: 嚴格 檢測 兩個樹 */
        public boolean equals(TreeNode x, TreeNode y) {

            /** 邊界條件 */
            if (x == null && y == null)
                return true;
            if (x == null || y == null)
                return false;

            /**  */
            return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
        }

        /** 子函數 1 級 */
        public boolean traverse(TreeNode s, TreeNode t) {
            /** 持續旅行 */
            return s != null && ( equals(s, t) || traverse(s.left, t) || traverse(s.right, t) );
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
