class Solution {
    
    public int maxSubArrayLen(int[] nums, int k) {
  
            Map<Integer, Integer> map = new HashMap();

            int sum = 0;
            int max = 0;

            for (int i = 0; i < nums.length; i++) {

                sum += nums[i];

                if (!map.containsKey(sum))      map.put(sum, i);
                /** 如果存在过这样的 sum，就不用在更新了，因为保存最小的就行了 */
                
                if (sum == k) {
                    
                       max = i + 1;

                } else if (map.containsKey(sum - k)) {  
                  /* 關鍵是看懂這一步，為何這麼來測試，自己畫圖看一看。有點類似pre sum */

                    max = Math.max(max, i - map.get(sum - k));
                }
            }
            return max; 
    }
}