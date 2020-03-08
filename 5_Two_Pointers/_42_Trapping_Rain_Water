class Solution {
    
    public int trap(int[] height) {

            /** 边界条件 */
            if(height == null || height.length < 3) return 0;

            /** 初始化 */
            int M = 0 /** M是输出 */, L_Max = 0, R_Max = 0;

            /** 定义指针 */
            int i = 0 /** 左头指针 */, j = (height.length -1) /** 右尾指针 */;

            /** 循环 */
            while(i<j) {

                    /** 每次都更新一下，左右最高点 left_Max & right_Max --> 左右指针会往中间压缩 */
                
                    L_Max = Math.max(L_Max, height[i]);

                    R_Max = Math.max(R_Max, height[j]);

                    if(L_Max < R_Max) { M += L_Max - height[i]; i++; }

                    if(L_Max >= R_Max) { M += R_Max - height[j]; j--; }

            }
            return M;
        }
}
