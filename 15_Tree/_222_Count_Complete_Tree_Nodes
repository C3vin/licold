class Solution {

       /** complete tree has 2^k nodes in the kTH level  **/

        /** 主函數 **/
        public int countNodes(TreeNode root) {

            /** 1. 邊界條件~ **/
            if (root == null) return 0;

            /** 2. 拿到樹的深度 | 第一層為 0 層 **/
            int d = computeDepth(root);

            /** 3. 另一個邊界條件 **/
            if (d == 0) return 1;


            /** 4. 左邊 = 1，右邊 = 2^d - 1 坐標最右邊 | 最後一行，從 1 到 **/
            int left = 1, right = (int) Math.pow(2, d) - 1 /** 深度 d 所能 承載的 個數 **/;

            /** 5. 定義 pivot **/
            int pivot;  /** 這個pivot，一直在變化  **/

            /** 6. 尋找中點，二分法 **/
            while (left <= right) {

                /** 6.1 找到中點  **/
                pivot = left + (right - left) / 2;

                /** 6.2 求證是否存在 **/
                if (exists(pivot, d, root)) left = pivot + 1;

                else right = pivot - 1;
            }

            /** 7. 返回最終結果 **/
            return (int)Math.pow(2, d) - 1 + left;
        }

        /** 計算樹的深度 | 如果只有 root，代表只有 一 層 **/
        public int computeDepth(TreeNode node) {

            int d = 0;
            while (node.left != null) {
                node = node.left;
                ++d;
            }
            return d;
        }

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right). Return True if last level node idx exists. Binary search with O(d) complexity.

        /** 總共只有 2^d - 1 個節點 **/
        public boolean exists(int idx /** pivot **/, int d /** 深度 **/, TreeNode node) {

            /** ~1 準備好最後一行的，左右邊界  **/
            int left = 0, right = (int)Math.pow(2, d) - 1;

            /** ~2 定義pivot  **/
            int pivot;

            /** ~3 只需要 二分法 d 次  **/
            for(int i = 0; i < d; ++i) {

                    /** ~3.1 拿到中間點  **/
                    pivot = left + (right - left) / 2;

                    /** ~3.2 如果比中點小， assign 去 左邊  **/
                    if (idx <= pivot) {
                            node = node.left;
                            right = pivot;
                    }
                    /** ~3.3 如果比中點小， assign 去 左邊  **/
                    else {
                            node = node.right;
                            left = pivot + 1;
                    }
            }

            return node != null;
        }
}