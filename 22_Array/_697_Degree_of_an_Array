/** Left and Right Index  **/
class Solution {
 
        public int findShortestSubArray(int[] nums) {

            Map<Integer, Integer> left = new HashMap(); 
            Map<Integer, Integer> right = new HashMap();
            Map<Integer, Integer> count = new HashMap();

            for (int i = 0; i < nums.length; i++) {

                    int x = nums[i];

                    /** 拿到元素最組邊的位置 **/
                     // left.putIfAbsent(x,i);  // 也可以这样， 但不知道为何很慢
                    if (left.get(x) == null) left.put(x, i);
                   
                    /** 更新最右邊位置  **/
                    right.put(x, i);

                    /** 數每个元素  **/
                    count.put(x, count.getOrDefault(x, 0) + 1);

            }

            /** 拿到degree **/
            int ans = nums.length;
            int degree = Collections.max(count.values());

            for (int x: count.keySet()) {

                /** 找到degree的 數字 --> 可能是multiple的!!! **/
                if (count.get(x) == degree) {

                    ans = Math.min(ans, right.get(x) - left.get(x) + 1);

                }
            }
            return ans;
        }
    
}