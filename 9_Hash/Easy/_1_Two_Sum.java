class Solution {
   
    /** Code on Feb 26, 2020 by Dior Xiong**/
    
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> a = new HashMap<Integer, Integer>(); 
        
        for(int i = 0; i<nums.length; i++) {
            
            a.put(target - nums[i], i); 
        
        }
        
        
        for(int j = 0; j < nums.length; j++) {
             
            if( a.containsKey(nums[j]) &&  j != a.get(nums[j]) )  {
                 
                return new int[]{ j, a.get(nums[j]) };
            }
        }
  
        return null;
    }
}

//////////////////////////////////////////////////////////////////////////////////// One Pass
 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> helper = new HashMap<>(); 
        
        for(int i = 0; i< nums.length; i++){
            
            if( helper.containsKey(target - nums[i]) ) return new int[]{i, helper.get(target - nums[i])}; 
              
            helper.put(nums[i], i); 
            
        }
        return new int[]{}; 
    }
}