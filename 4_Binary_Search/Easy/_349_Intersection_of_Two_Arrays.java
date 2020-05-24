class Solution {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>(); 
        
        Arrays.sort(nums2); 
        
        /** 看nums1的元素是否存在于 nums2 **/
        for(Integer num:nums1){
            
            if(binarySearch(num, nums2)){
                set.add(num); 
            }
            
        }
        
        /** 制造结果集 **/
        int i = 0; 
        int[] result = new int[set.size()]; 
        
        /**  把hash的结果，存放到 int[] **/
        for(Integer num:set) {
            result[i++] = num; 
        }
        
        return result; 
    }
    
    /** 二分内核 **/
    public boolean binarySearch(int target, int[] nums){
        
        int low = 0; 
        int high = nums.length - 1; 
        
        while(low <= high){
            
            int mid = low + (high - low)/2; 
            
            if((nums[mid] == target)) return true; 
            
            if(nums[mid] > target) high = mid - 1; 
            else low = mid + 1; 
            
        }
        
        return false;
    }
 
}
