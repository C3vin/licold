class Solution {

        /** Heap **/
        public List<Integer> topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> count = new HashMap();

            for (int n: nums) count.put(n, count.getOrDefault(n, 0) + 1);
              
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>( (n1, n2) -> count.get(n1) - count.get(n2) );

            for (int n: count.keySet()) {
                
                heap.add(n);
                
                if (heap.size() > k)    // 小的加在最顶
                    heap.poll();
            }

            // build output list
            List<Integer> top_k = new LinkedList();

            while (!heap.isEmpty()) top_k.add(heap.poll());

            Collections.reverse(top_k);

            return top_k;
        }
    
}