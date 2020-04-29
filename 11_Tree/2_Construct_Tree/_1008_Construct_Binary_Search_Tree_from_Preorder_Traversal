class Solution {

        public TreeNode bstFromPreorder(int[] preorder) {

            /** 長度 */
            int n = preorder.length;

            /** 返回為空 */
            if (n == 0) return null;

            /** preorder，第一個是root */
            TreeNode root = new TreeNode(preorder[0]);

            /** 製造deque */
            Deque<TreeNode> deque = new ArrayDeque<TreeNode>();

            /** 塞入root */
            deque.push(root);

            /** 遍歷，n是input的長度 */
            for (int i = 1; i < n; i++) {

                /** 拿出node和child */
                TreeNode node = deque.peek();

                //System.out.println( "deque.peek()" + node.val);
                TreeNode child = new TreeNode(preorder[i]);

                /** 如果deque不空，並且 node 比 孩子小，就彈出這個node --> 找到合適的node */

                /** 一直pop所有的node，找到child的大爸爸 */
                while (!deque.isEmpty() && deque.peek().val < child.val)
                    node = deque.pop();

                /** 如果node比孩子小，孩子是右邊的葉子 --> 否則就是左葉子 */
                if (node.val < child.val) { /** 如果deque空了，都沒有大爸爸，說明這是小爸爸 */
                                         node.right = child;
                } else node.left = child;

                /** push是加到頭，peek和pop都是對 --> 頭部  */
                deque.push(child);
            }
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
