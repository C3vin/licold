public class Solution {

    public int findMaxLength(int[] nums) {           // preSum + Hashmap (let 0 be -1)
        
        Map<Integer, Integer> map = new HashMap<>(); // Create a map 
        
        map.put(0, -1);                              //  (sum, index)
        
        int maxlen = 0, sum = 0;                     // set up 
        
        //Loop
        for (int i = 0; i < nums.length; i++) {
            
                sum = sum + (nums[i] == 1 ? 1 : -1);  

                if (map.containsKey(sum)) {

                    maxlen = Math.max(maxlen, i - map.get(sum));   /* 两个点的presum，如果一样，说明这两个点中间，加起来是0 */

                } else {

                    map.put(sum, i);

                }
        }
        
        return maxlen;
    }
}
