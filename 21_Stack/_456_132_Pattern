class Solution {
    
    public boolean find132pattern(int[] nums) {
      
            /** 建立 stack */
            Deque<Integer> stack = new LinkedList<>();

            /** 初始化第三个数字。第一个数字，比它小。第二个数字，比它大 */
            int s_3 = Integer.MIN_VALUE;

            // 遍历所有数字
            for (int i = nums.length - 1; i >= 0; i--) {

                        // 第一个数字比第三个小
                        if (nums[i] < s_3) {
                            return true;

                        } else {
                            
                            // stack不是空，并且，第二个数字比第三个大 --> 一旦出现，比stack大的，就更新s_3 --> 这题用 3 2 9 9 8 为例子，自己在纸上跑一下！
                            while ( !stack.isEmpty() && nums[i] > stack.peek() ) {
                                
                                s_3 = Math.max(s_3, stack.pop());
                                
                            }
                        }
                        stack.push(nums[i]);
            }
            return false;
    }
}