class Solution {
    
            public int pathSum(TreeNode root, int sum) {

                /** Corner Case  */
                if (root == null) {  return 0;  }

                /** Call function as return */

                return pathSumFrom(root, sum) +       /** Iterate the root itself ** */

                       pathSum(root.left, sum) +      /** Check the leaf --> and Iterate */

                       pathSum(root.right, sum);

            }

            private int pathSumFrom(TreeNode root, int sum) {

                /** Corner Case */
                if (root == null) return 0;

                /**  */
                return  (root.val == sum ? 1 : 0) +                       /**  If both sides are equal   */
                        pathSumFrom(root.left, sum - root.val) +    /**  go further with left      */
                        pathSumFrom(root.right, sum - root.val);    /**  go further with right     */
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
