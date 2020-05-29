class Solution {
    
    public int countNodes(TreeNode root) {
        
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        
       // System.out.println("1:"+d+";"+left+";"+right);
        while (left + 1 < right) {
          pivot = left + (right - left) / 2;
          if (exists(pivot, d, root)) left = pivot;
          else right = pivot;
        }
        System.out.println("2:"+left+";"+right);
        if(exists(right,d,root))
            return (int)Math.pow(2, d) + right;
        else
            return (int)Math.pow(2, d) + left;
        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
    }
    
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; ++i) {
          pivot = left + (right - left) / 2;
          if (idx <= pivot) {
            node = node.left;
            right = pivot;
          }
          else {
            node = node.right;
            left = pivot + 1;
          }
        }
        return node != null;
      }
    
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
          node = node.left;
          ++d;
        }
        return d;
      }
}