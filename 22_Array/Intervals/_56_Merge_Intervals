class Solution {

    public int[][] merge(int[][] intervals) {
        
        // 1. Corner case 
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null) return res.toArray(new int[0][0]);
        
        // 2. Sort the input, small to big
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // 3. Define start && end 
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        // 4. Loop
        for(int[] i : intervals) {
            
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            
            else {
                
                res.add(new int[]{start, end});
                
                start = i[0];
                end = i[1];
                
            }
        }
        
        res.add(new int[]{start, end});
        
       return res.toArray(new int[0][0]);
         
    }
    
    
}