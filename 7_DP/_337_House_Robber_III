class Solution {

        public int rob(TreeNode root) {

            int[] result = robHelper(root);

            /** 0，1 --> 偷或者不偷 */
            return Math.max(  result[0],  result[1]  );

        }

        private int[] robHelper(TreeNode root) {

            /** 边界条件 */
            if(root == null) return new int[2];

            /** 先定义 result */
            int[] result = new int[2];

            int[] left = robHelper(root.left);
            int[] right = robHelper(root.right);

            /** 不偷 本节点 */
            result[0] = Math.max( left[0], left[1] ) + Math.max(  right[0], right[1] );

            /** 偷 本节点 */
            result[1] = root.val + left[0] + right[0];

            return result;
         }
}
