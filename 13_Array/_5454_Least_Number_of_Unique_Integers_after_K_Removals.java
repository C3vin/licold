class Solution {
     
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
 
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int a:arr){

            map.putIfAbsent(a, 0);

            map.put(a, map.get(a)+1);
        }

        for(int a:arr){

            if(map.get(a)!=null){
                
                pq.offer(new int[]{a, map.get(a)});

                map.remove(a);
            }
        }

        int[] cur;

        while( k > 0 ){

                cur = pq.poll();
                k -= cur[1];
        }
        
        if(k<0) return pq.size()+1;
        else return pq.size();
    }
}