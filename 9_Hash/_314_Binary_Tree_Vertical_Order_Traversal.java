class Solution {

        public List<List<Integer>> verticalOrder(TreeNode root) {

            /** 1. 製造結果集  **/
            List<List<Integer>> result = new ArrayList();

            /** 2. 邊界條件  **/
            if (root == null) return result;

            /** 3. 製造兩個Queue  **/
            Queue<TreeNode> bfsQ = new LinkedList();
            Queue<Integer> indexQ = new LinkedList();

            /** 4. 製造TreeMap  **/
            TreeMap<Integer, List<Integer>> map = new TreeMap();

            /** 5. 塞入root給 bsfQ  **/
            bfsQ.offer(root);

            /** 6. 初始化 indexQ  **/
            indexQ.offer( 0);//we set the root as index 0, left will be negative, right will be positive

            /** 7. BFS戰鬥  **/
            while (!bfsQ.isEmpty()) {

                /** ~1 拿出size  **/
                int qSize = bfsQ.size();

                /** ~2 遍歷Queue  **/
                for (int i = 0; i < qSize; i++) {

                    /** ~1.1 拿出 curr 的 node  **/
                    TreeNode curr = bfsQ.poll();

                    /** ~1.2 拿出index **/
                    int index = indexQ.poll();

                    /** ~1.3 如果存在index，加入當前值  **/
                    if (map.containsKey(index)) {

                        map.get(index).add(curr.val);

                    /** ~1.4 否則，加入index  **/
                    } else if (!map.containsKey(index)) {

                        /** ~~1 創新一個list  **/
                        List<Integer> list = new ArrayList();

                        /** ~~2 list加入當前值  **/
                        list.add(curr.val);

                        /** ~~3 更新map  **/
                        map.put(index, list);
                    }

                    /** ~1.5 更新左邊  **/
                    if (curr.left != null) {

                        bfsQ.offer(curr.left);

                        indexQ.offer(index - 1);
                    }

                    /** ~1.5 更新右邊 **/
                    if (curr.right != null) {

                        bfsQ.offer(curr.right);
                        indexQ.offer(index + 1);
                    }
                }
            }

            for (int i : map.keySet()) {
                result.add(map.get(i));
            }

            return result;
        }
    
}
