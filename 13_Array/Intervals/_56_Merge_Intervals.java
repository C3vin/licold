class Solution {
    
    int[][] M = null; 
    
	public int[][] merge(int[][] intervals) {
        
        M = intervals;
	
        if (M.length <= 1)
			return M;
 
		Arrays.sort(M, (a,b) -> (a[0]-b[0]));

		List<int[]> res = new ArrayList<>();
		
        int[] curr = M[0];
		
        res.add(curr);
		
        for (int[] i : M) {
            
			if (i[0] <= curr[1])  
                
				curr[1] = Math.max(curr[1], i[1]);
			else {                             
                
				curr = i;
				res.add(curr);
			}
		}

        int[][] newRes = new int[res.size()][2]; 
        
        res.toArray(newRes); 
        
		//return result.toArray(new int[0][0]); 
         return newRes;
	}
}