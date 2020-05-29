class Solution {
   
        public int findDuplicate(int[] nums) {  
             
            int low = 1; //  注意，这里不是序号，而是数字本身 
            int high = nums.length - 1;  
            
            int mid = 0; 
            int cnt = 0; 
            
            while (low + 1 < high) {      
                
				    mid = low + (high - low)/2; 
		 
					for (int a : nums)  if (a <= mid)  ++cnt;        
					  
					if (cnt <= mid) low = mid;    
					else high = mid;   
                
                    cnt = 0; 
			}   
		 
		   for (int a : nums)  if (a == low)  ++cnt;   
		   
		   if(cnt > 1) return low; 
		   else return high; 
            
        }
}
