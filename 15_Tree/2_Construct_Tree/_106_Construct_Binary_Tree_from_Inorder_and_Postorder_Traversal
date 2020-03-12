class Solution {

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            if (inorder == null || postorder == null || inorder.length != postorder.length) {
                return null;
            }

            /** 制作 inorder的 HashMap **/
            HashMap<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);

            /**At the beginning, both start from 0 to nums.length-1*/
            return buildTreeRecursively(
                    inorderMap, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1
            );

        }

        private TreeNode buildTreeRecursively(Map<Integer, Integer> inorderMap, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {

            if (postorderStart > postorderEnd || inorderStart > inorderEnd) return null;

            /** 找到 postOrder 最后一个元素 --> 他是root  **/
            TreeNode root = new TreeNode(postorder[postorderEnd]);

            /** 这里 inOrder  **/
            int inRoot = inorderMap.get(postorder[postorderEnd]);

            int numsLeft = inRoot - inorderStart;

            root.left = buildTreeRecursively(
                    inorderMap, inorderStart, inRoot - 1,
                    postorder, postorderStart, postorderStart + numsLeft - 1
            );

            root.right = buildTreeRecursively(
                    inorderMap, inRoot + 1, inorderEnd,
                    postorder, postorderStart + numsLeft, postorderEnd - 1
            );

            return root;

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
