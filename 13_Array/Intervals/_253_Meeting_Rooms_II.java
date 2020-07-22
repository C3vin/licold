class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        	//1. sort all the intervals by their start time
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
            //2. use a priority queue to hold all current ongoing(or opened) meeting rooms
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
            //3. keep updating the max meeting room numbers needed
            int maxRoom = 0;
        
            for (var i : intervals) {
                
                if (!pq.isEmpty() && pq.peek()[1] <= i[0]) {
                    pq.poll();
                }
                
                pq.add(i);
                
                maxRoom = Math.max(maxRoom, pq.size());
            }

            return maxRoom;
    }
}

