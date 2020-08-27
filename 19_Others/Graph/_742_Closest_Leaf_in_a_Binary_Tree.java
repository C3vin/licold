class Solution {

            public int findClosestLeaf(TreeNode root, int k) {

                if(root.left == null && root.right == null) return k;
                 
                Map<TreeNode, List<TreeNode>> graph = new HashMap(); /** 製造graph */
 
                dfs(graph, root, null);  /** 戰鬥地點 --> 構建圖 */
 
                Queue<TreeNode> queue = new LinkedList(); /** 製造queue */
 
                Set<TreeNode> seen = new HashSet(); /** 看過的node */
 
                for (TreeNode node: graph.keySet()) {  /** 找到 k 對應的node --> 對應的圖  */
                    
                    if (node != null && node.val == k) {
                        
                        queue.add(node);
                        seen.add(node);
                    }
                }
 
                while (!queue.isEmpty()) {  /** 對queue進行循環 */

                    TreeNode node = queue.poll(); /** 拿出元素 */

                    if (node != null) { /** 如果元素有效 */

                        if (graph.get(node).size() <= 1)  /** 如果是葉子 */  return node.val;
                             
                        for (TreeNode nei: graph.get(node)) {   /** 如果不是葉子，拿下一層的node */
                            
                            if (!seen.contains(nei))  { /** 如果沒見過 */
                                
                                seen.add(nei);
                                
                                queue.add(nei);
                            }
                        }
                    }
                }
                return Integer.MAX_VALUE; // 其实这句话永远不会被运行 --> 一个树怎么会没有叶子? (边界条件已经考虑了)
            }
 
            public void dfs(Map<TreeNode, List<TreeNode>> graph /** graph */ , TreeNode node /** root */, TreeNode parent /** parents */) {

                if (node != null) { /** 構建 graph */

                    graph.putIfAbsent( node, new LinkedList<TreeNode>() ); 
                    graph.putIfAbsent( parent, new LinkedList<TreeNode>() );                     
  
                    graph.get(node).add(parent);
                    graph.get(parent).add(node);

                    dfs(graph, node.left, node);
                    dfs(graph, node.right, node);
                }
            }
}