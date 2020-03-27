// 思路视频： https://youtu.be/s8WoEa4P0lY?t=259 

// 思路视频： https://youtu.be/s8WoEa4P0lY?t=259 

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
 
        this.stack = new Stack<TreeNode>();
 
        this._leftMostInorder(root);
    }

    private void _leftMostInorder(TreeNode root) {
 
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }
 
    // 我们要Call这个函数
    public int next() {
 
        // 拿到这个最小的node
        TreeNode topmostNode = this.stack.pop();
 
        // 把这个最小的node，的右手给 _leftMostInorder --> 然后_leftMostInorder 会一路往左边inorder吧左叶子传递进去
        if (topmostNode.right != null)  
            this._leftMostInorder(topmostNode.right);
         
        return topmostNode.val;
    }
 
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
    
}