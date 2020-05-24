class Solution {
    
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
                     
                Set<Integer> set = new HashSet<>();  /** 把要删除的，放入 set **/
            
                for (int i : to_delete) set.add(i);
             
                List<TreeNode> res = new ArrayList<>();  /** 制造答案 */
             
                if ( !set.contains(root.val) ) res.add(root);   /** 先把root加进去，假如不在被delete的list里面的话 */
             
                dfs(root, set, res);  /** DFS **/
            
                return res;
        }

        private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {

            if (node == null)  return null;
             
            node.left = dfs(node.left, set, res);
            node.right = dfs(node.right, set, res);
            
            if (set.contains(node.val)) {
                
					if (node.left != null) res.add(node.left);
					if (node.right != null) res.add(node.right);
					
					return null;
            }
            return node;
       }
}
