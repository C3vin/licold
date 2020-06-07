class Solution {

     public int[] getStrongest(int[] arr, int k) {
         
        int n = arr.length;
        Arrays.sort(arr);
         
        int m = arr[(n - 1) / 2];
         
        PriorityQueue<Integer> pq 
        = new PriorityQueue<>( 
                               (a, b) -> Math.abs(a - m) == Math.abs(b - m) ? a - b : Math.abs(a - m) - Math.abs(b - m)
                             );
        
         for (int a : arr) {
             
            pq.offer(a);
             
            if (pq.size() > k) pq.poll();
             
        }
         
        return pq.stream().mapToInt(i -> i).toArray();
    }
}