class Solution {
    
    /** Using Cyclic Replacements | no extra space  **/
    
    public void rotate(int[] nums, int k) {
        
            /** 1. 對 k 取模 **/
            k = k % nums.length;

            /** 2. 數目  **/
            int count = 0;

            /** 3. 只要count没超过总长度。问题: start什么时候会++ **/
            for (int start = 0; count < nums.length; start++) {
    
                        /** ~1 預留當前位置  **/
                        int current = start;

                        /** ~2 拿到原始位置的值  **/
                        int prev = nums[start];

                        do {
                                        int next = (current + k) % nums.length; // 获取下一坐标的位置   
                                        int temp = nums[next];  // 获取下一坐标对应的值 
                            
                                        nums[next] = prev;  // 更新下一坐标的值
                                          
                                        count++;  // 更新完后，count加一
                            
                                        prev = temp;  // 把 "下一坐标对应的值(存在于temp)", 给prev

                                        current = next;  // 更新当前位置，为"下一坐标对应位置"
   
                        } while (start != current);
            }
    }
}