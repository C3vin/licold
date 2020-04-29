class Solution {
    
    /* 题目意思: https://www.youtube.com/watch?v=3w8kGAsBxYQ 
       这题要用Deque的解法: Deque存的是下标，不是值 
       
       这题需要自己拿笔划一下！自己跑一遍！
    
    */
    
    public int[] maxSlidingWindow(int[] nums, int k) {

            /** 1. Corner Case  **/
            if (nums == null || nums.length == 0) return new int[0];

            /** 2. Define deque  **/
            Deque<Integer> deque = new LinkedList<>();

            /** 3. Define output  **/
            int[] res = new int[nums.length + 1 - k];

            /** 4. Traver all the input element   **/
            for (int i = 0; i < nums.length; i++) {

                /** 注意：1. 這裡的滑動窗口，從頭到尾，並不總有k的元素，有的元素可能被刪除了
                 *       2. 滑動窗口，是按照元素，從大到小排序的                          **/

                /** ~1  第一個元素（也就是永远最大的那个元素，的下标），如果等於i-k （自己拿笔划一下,也就是等于窗子之前的下标）
                        那麼這個元素，已經不再窗子裡面了，需要踢掉。 
                        
                        在这里peekFirst() = peek()!
                        **/
                if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();

                /** ~2  如果窗子，最後一個元素，比 新來的老鐵小，那麼踢走他，給老鐵讓位 （其實是踢走 比老鐵小的 所有元素）**/
                while ( !deque.isEmpty() && nums[deque.peekLast()] < nums[i] ) deque.removeLast();

                /** ~3  老鐵就坐 **/
                deque.offerLast(i);

                /** ~4 拿出窗子，第一個元素 --> and fill the output **/
                if ((i + 1) >= k) 
                    res[i + 1 - k] = nums[deque.peekFirst()];
  
            }
            return res;
        }
    
}