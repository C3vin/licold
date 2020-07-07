class Solution {
      
     public List<Integer> distanceK(TreeNode treeRoot, TreeNode startNode, int targetDistance) {
 
            Map<TreeNode, TreeNode> dadMap = new HashMap();
 
            dad(dadMap, treeRoot, null);
 
            Queue<TreeNode> queue = new LinkedList();
         
            queue.add(startNode);
 
            Set<TreeNode> seen = new HashSet();
 
            seen.add(startNode);
 
            int currentLayer = 0;
 
            while (!queue.isEmpty()) {
 
                        if (currentLayer == targetDistance) return getLayer(queue);
 
                        int layerSize = queue.size();
 
                        for (int i = 0; i < layerSize; i++) {
 
                            TreeNode curr = queue.poll();
 
                            if (curr.left != null && !seen.contains(curr.left)) {
                                seen.add(curr.left);
                                queue.offer(curr.left);
                            }
 
                            if (curr.right != null && !seen.contains(curr.right)) {
                                seen.add(curr.right);
                                queue.offer(curr.right);
                            }

                            /** ~3. 檢查老爸 **/
                            TreeNode dad = dadMap.get(curr);

                            if (dad != null && !seen.contains(dad)) {
                                seen.add(dad);
                                queue.offer(dad);
                            }

                        }
                        currentLayer++;
            }

            return new ArrayList<Integer>();
        }

        /** 把樹擼一遍，找到所有節點的父母  **/
        private void dad(Map<TreeNode, TreeNode> dadMap, TreeNode root, TreeNode parent) {

            /** 1. 邊界條件 **/
            if (root == null) { return; }

            /** 2. 製造root的爸媽  **/
            dadMap.put(root, parent);

            dad(dadMap, root.left, root);
            dad(dadMap, root.right, root);
        }

        /** 找出當前Layer的節點 **/
        private List<Integer> getLayer(Queue<TreeNode> queue) {
            
            List<Integer> res = new ArrayList<>();
                
            for (TreeNode node : queue) {
                res.add(node.val);
            }
            
            return res;
        }
}