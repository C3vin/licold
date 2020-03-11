class Solution {
      
     public List<Integer> distanceK(TreeNode treeRoot, TreeNode startNode, int targetDistance) {

            /** 1. Create the node to parent map and populate it */
            Map<TreeNode, TreeNode> node_To_Parent_Map = new HashMap();

            /** 制造  **/
            populateNodeToParentMap(node_To_Parent_Map, treeRoot, null);

            /** 2. Create the queue that we will use for the breadth first search. Add the start node to the queue */
            Queue<TreeNode> queue = new LinkedList();
            queue.add(startNode);

            /** 3. 需要一個 HashTable 來檢查訪問情況 **/
            Set<TreeNode> seen = new HashSet();

            /** 4. 加入起始點  **/
            seen.add(startNode);

            /** 5. When our search starts, we are standing at layer 0 */
            int currentLayer = 0;

            /** 6. 開始戰鬥  **/
            while (!queue.isEmpty()) {

                        /** ~1 Is this the layer we want? If so, extract and return it */
                        if (currentLayer == targetDistance) return extractLayerFromQueue(queue);

                        /** ~2 BFS **/
                        int layerSize = queue.size();

                        /** ~3 數清楚，queue裡面有幾個  **/
                        for (int i = 0; i < layerSize; i++) {

                            /** ~3.1 拿出當前的 Node  **/
                            TreeNode currentNode = queue.poll();

                            /** ~3.2 檢查當前，左邊的Node **/
                            if (currentNode.left != null && !seen.contains(currentNode.left)) {
                                seen.add(currentNode.left);
                                queue.offer(currentNode.left);
                            }

                            /** ~3.2 檢查當前，左邊的Node **/
                            if (currentNode.right != null && !seen.contains(currentNode.right)) {
                                seen.add(currentNode.right);
                                queue.offer(currentNode.right);
                            }

                            /** ~3. 檢查老爸 **/
                            TreeNode parentOfCurrentNode = node_To_Parent_Map.get(currentNode);

                            if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                                seen.add(parentOfCurrentNode);
                                queue.offer(parentOfCurrentNode);
                            }

                        }
                        currentLayer++;
            }

            return new ArrayList<Integer>();
        }

        /** 把樹擼一遍，找到所有節點的父母  **/
        private void populateNodeToParentMap(Map<TreeNode, TreeNode> node_To_Parent_Map, TreeNode root, TreeNode parent) {

            /** 1. 邊界條件 **/
            if (root == null) { return; }

            /** 2. 製造root的爸媽  **/
            node_To_Parent_Map.put(root, parent);

            populateNodeToParentMap(node_To_Parent_Map, root.left, root);
            populateNodeToParentMap(node_To_Parent_Map, root.right, root);
        }

        /** 找出當前Layer的節點 **/
        private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
            List<Integer> extractedList = new ArrayList();
            for (TreeNode node : queue) {
                extractedList.add(node.val);
            }
            return extractedList;
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
