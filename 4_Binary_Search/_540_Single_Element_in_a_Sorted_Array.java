class Solution {
    
    // 思路  https://youtu.be/uJa9Q-05JxY?t=229  
    // 已经自己录制视频
    
    public int singleNonDuplicate(int[] nums) {
      
                int lo = 0;
                int hi = nums.length - 1;

                /**
                 *
                 *  0  --> 00^01 = 01    就是数对的概念，每一对数，是互相检测和相等
                 *  1  --> 01^01 = 10
                 *
                 *  2  --> 10^01 = 11
                 *  3  --> 11^01 = 10
                 *
                 *  4  --> 100^001 = 101
                 *  5  --> 101^001 = 100
                  
                 *
                 * */

                while (lo < hi) {

                    int mid = lo + (hi - lo) / 2;

                    if (nums[mid] == nums[mid^1]) {
                        lo = mid + 1;

                    } else {
                        hi = mid;
                    }

                }

                return nums[lo];
    }
}

 
///////////////////  Solution 2
class Solution {
	
       public static int singleNonDuplicate(int[] nums) {
           
            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                
                // We want the first element of the middle pair,
                // which should be at an even index if the left part is sorted.
                // Example:
                // Index: 0 1 2 3 4 5 6
                // Array: 1 1 3 3 4 8 8
                //            ^
                int mid = start + (end - start) / 2;
                if (mid % 2 == 1) mid--;

                // We didn't find a pair. The single element must be on the left.
                // (pipes mean start & end)
                // Example: |0 1 1 3 3 6 6|
                //               ^ ^
                // Next:    |0 1 1|3 3 6 6
                if (nums[mid] != nums[mid + 1]) end = mid;

                // We found a pair. The single element must be on the right.
                // Example: |1 1 3 3 5 6 6|
                //               ^ ^
                // Next:     1 1 3 3|5 6 6|
                else start = mid + 2;
            }
           
            // 'start' should always be at the beginning of a pair.
            //  When 'start > end', start must be the single element.
            return nums[start];
     }
}