class Solution {
    
    // iPad Pro 讲解  -->  单调栈
    
    public int[] nextGreaterElements(int[] nums) {

                int[] res = new int[nums.length];

                Stack<Integer> stack = new Stack<>();
 
                for (int i = 2 * nums.length - 1; i >= 0; --i) {

                        // i 实际的位置
                        int R = i % nums.length; 

                        while (!stack.empty() && nums[ R ] >= nums[stack.peek()]) {  // --> 自己拿笔划一下
                            stack.pop();
                        }

                        res[ R ] = stack.empty() ? -1 : nums[   stack.peek()   ];

                        stack.push( R );  // -->  stack存的是坐标 
                }
        
                return res;
            }
    
}