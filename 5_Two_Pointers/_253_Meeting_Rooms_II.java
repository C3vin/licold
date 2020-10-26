class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        
    if (intervals.length == 0) {
      return 0;
    }

    Integer[] start = new Integer[intervals.length];
    Integer[] end = new Integer[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
 
    Arrays.sort( start, (a,b) -> a - b ); // 或者直接 Arrays.sort( start ); 
    Arrays.sort( end, (a,b) -> a - b );
 
    int s = 0, e = 0;

    int usedRooms = 0;
 
    while (s < intervals.length) {
 
      if (start[s] >= end[e]) {
                                        usedRooms -= 1;
                                        e += 1;
      }
       
      usedRooms += 1;
      s += 1;

    }
    return usedRooms;
  }
}