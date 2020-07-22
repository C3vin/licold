class Solution {
 
   public boolean checkSubarraySum(int[] nums, int k) {
       
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){ {put(0,-1);} };
       
        int prefixSum = 0;
       
        for (int i=0;i<nums.length;i++) {
            
            prefixSum += nums[i];
            
            if (k != 0) prefixSum %= k; 
            
            Integer prev = map.get(prefixSum);
            
            if (prev != null && i - prev > 1 )  return true;
            else map.put(prefixSum, i);
        }
       
        return false;
    }
    
}