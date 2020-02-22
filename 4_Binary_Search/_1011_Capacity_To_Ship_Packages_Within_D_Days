class Solution {
    
        public int shipWithinDays(int[] weights, int D) {
            
            int left = 0, right = 0;
             
            /** Leftbound is the maximum value of the array**/
            /** Rightbound is the maximum value of the array**/
            for (int w: weights) {
                left = Math.max(left, w);
                right += w;
            }
            
            /** Binary Search **/
            while (left < right) {
                
                int mid = (left + right) / 2, need = 1, cur = 0;
                
                /** to calculate the total need for the days  **/
                for (int w: weights) {
                    if (cur + w > mid) {
                        need += 1;
                        cur = 0;
                    }
                    cur += w;
                }
                
                /** compare the days **/
                if (need > D) left = mid + 1;
                else right = mid;

            }
            
            return left; 
        }
}
