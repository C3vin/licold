class Solution {
    
     public List<List<String>> printTree(TreeNode root) {

            /** 制造答案集 */
            List<List<String>> res = new LinkedList<>();

            /** 确定树的高度 */
            int height = root == null ? 1 : getHeight(root);

            /** 定好多少行，和多少列 */
            int rows = height, columns = (int) (Math.pow(2, height) - 1);

            /** 制造 row 元素 */
            List<String> row = new ArrayList<>();

            /** 制造 row 容器 */
            for(int i = 0; i < columns; i++)  row.add("");

            /** 制造 矩阵 */
            for(int i = 0; i < rows; i++)  res.add(new ArrayList<>(row));

            /**  */
            populateRes(root, res, 0, rows, 0, columns - 1);

            return res;

        }

        public void populateRes(TreeNode root,              // 进入的节点
                                List<List<String>> res,     // 结果集合
                                int row,                    // 目前在第几行
                                int totalRows,              // 总共多少行 --> 这个不会变
                                int i,                      // 左指针
                                int j                       // 右指针
                               ){

            // 边界条件
            if (row == totalRows || root == null) return;

            /** 把root放进去 */
            res.get(row).set( (i+j)/2, Integer.toString(root.val)) ;

            // 左边                                         左指针               右指针 
            populateRes(root.left,  res, row+1, totalRows,   i,                (i+j)/2 - 1  );

            // 右边                                         左指针               右指针
            populateRes(root.right, res, row+1, totalRows, (i+j)/2 + 1,        j            );

        }


        /** 拿到树的高度 */
        public int getHeight(TreeNode root) {
            
            if (root == null) return 0;
            
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
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
