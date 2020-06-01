class Solution {
   
  /** a. missing --> Checking how many items are missing before the index "idx" **/  
  int missing(int idx, int[] nums) {
      return nums[idx] - nums[0] - idx;
  }
    
  /** main function **/  
  public int missingElement(int[] nums, int k) {
      
    /** 1. Get the length**/  
    int n = nums.length;
  
    /** 2. If k larger than total missing items, then count outside of the array  **/      
    if (  k   >   missing(n - 1, nums)  )
      return nums[n - 1] +  ( k - missing(n - 1, nums) ) ;

    /** 3. Binary Search **/  
    int left = 0; 
    int right = n - 1; 

    int mid;
     
    while (left != right) {
    
      mid = left + (right - left) / 2;

      if (missing(mid, nums) < k) left = mid + 1;
      else right = mid;
    
    }

    return nums[left - 1] + k - missing(left - 1, nums);   
           /** why left will overflow? because position "left" hold more missing number than "k" **/
  }
}
