class Solution {
   
    /**

    Complexity
    Time O(NlogM), where M = max(A)
    Space O(1)

    **/
 
    public int smallestDivisor(int[] A, int threshold) {
        
        /** 设定 左右 界限 **/
        int left = 1, right = (int)1e6;
        
        /** 循环 **/
        while (left < right) {
            
            /** 拿到中点 **/
            int m = left + (right - left) / 2, sum = 0;
            
            /** 拿到sum **/
            for (int i : A)  sum += (i- 1 + m) / m;
            
            /** 用来跟阈值比较 **/
            if (sum > threshold)
                left = m + 1;
            else
                right = m; 
        }
        return left;
    }
}
