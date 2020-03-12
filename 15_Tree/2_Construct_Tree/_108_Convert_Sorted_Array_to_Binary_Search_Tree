class Solution {
    
    public TreeNode sortedArrayToBST(int[] num) {

            /** corner case */
            if (num.length == 0) {
                return null;
            }

            /** Start war!!! */
            TreeNode head = helper(num, 0, num.length - 1);

            return head;
        }

        /** Sub Function */
        public TreeNode helper(int[] num, int low, int high) {

            /** check if should continue */
            if (low > high) { // Done
                return null;
            }

            /** find the middle point */
            int mid = (low + high) / 2;

            /** make up a TreeNode */
            TreeNode node = new TreeNode(num[mid]);

            node.left = helper(num, low, mid - 1);
            node.right = helper(num, mid + 1, high);

            return node;
        }
    
}