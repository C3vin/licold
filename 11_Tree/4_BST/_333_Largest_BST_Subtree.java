public class Solution {

            /** 初始化 结果  */
            int max = 0;

            /** 主函数 */
            public int largestBSTSubtree(TreeNode root) {

                /** 边界条件 */
                if (root == null) { return 0; }

                traverse(root);
                
                return max;
            }

            /** 开始战斗 */
            private sub_BST traverse(TreeNode root) {

                /** 如果root是空，边界条件 */
                if (root == null) { return new sub_BST(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }

                /** 左右测试 */
                sub_BST left = traverse(root.left);
                sub_BST right = traverse(root.right);

                /** 假如不合格 */
                if (       left.size == -7
                        || right.size == -7
                        || root.val <= left.upper /** BST不合格 */
                        || root.val >= right.lower /** BST不合格 */)
                {
                    return new sub_BST(-7 /** -7只是一个编号，说明错误  */, 0, 0);
                }

                /** 假如左右树都是BST，那么两边size相加 */
                int size = left.size + 1 + right.size;

                /** 找到max */
                max = Math.max(size, max);

                /** 返回BST，和它的最大，最小值 */
                return new sub_BST(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
            }
        }

/** 子class */
class sub_BST {

    int size;
    
    int lower;
    int upper;

    sub_BST(int size, int lower, int upper) {
        
        this.size = size;
        this.lower = lower;   // 樹的最小值
        this.upper = upper;   // 樹的最大值
    }
    
}
