class Solution {
 
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

            List<Integer> ans = new LinkedList();  /** 1. 製造答案集 **/
 
            dfs(root, target, K, ans);  /** 3. DFS  **/

            return ans;
        }
 
        public int dfs(TreeNode node, TreeNode target, int K, List<Integer> ans) {  /** 3. DFS  **/
 
            if (node == null)  return -911;   /** -911就是 返回无效 的意思 **/
            
            if (node == target) {
                subtree_add(node, 0, K, ans);
                return 1;
            }  

            int L = dfs(node.left, target, K, ans);
			int R = dfs(node.right, target, K, ans);

            if (L != -911) {
                
                if (L == K) ans.add(node.val);
                
                subtree_add(node.right, L + 1, K, ans);
                return L + 1;
            }
			
			if (R != -911) {
                
                if (R == K) ans.add(node.val);
                
                subtree_add(node.left, R + 1, K, ans);
                return R + 1;
            } 
      
    	  return -911;
        }
 
        public void subtree_add(TreeNode node, int dist, int K, List<Integer> ans) { // Add all nodes 'K - dist' from the node to answer.

            if (node == null) return;

            if (dist == K)
                ans.add(node.val);
            else {
                subtree_add(node.left, dist + 1, K, ans);
                subtree_add(node.right, dist + 1, K, ans);
            }
        }
}

 