class Solution {
    
    public int findMin(int[] nums) {
        
        if( nums == null || nums.length == 0 ) return -1; 
        
        if( nums.length == 1 || nums[0] < nums[nums.length-1] ) return nums[0];
     
        int low = 0; 
        int high = nums.length - 1; 
        
        int mid; 
        
        while(low + 1 < high){
            
            mid = low + (high-low)/2; 
            
            if(nums[low] < nums[mid]) low = mid; 
            
            if(nums[low] > nums[mid]) high = mid; 
            
            if(nums[low] == nums[mid]) low = mid; 
        }
        
        if(nums[low]>nums[high]) return nums[high]; 
    
        if(nums[low]<nums[high]) return nums[low]; 
        
        return -1; 
    }
}