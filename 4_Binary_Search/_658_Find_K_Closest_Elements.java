class Solution {
 
 

        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            List<Integer> res = new ArrayList<>();

            /** 看视频看视频看视频！！！！！！！！！！！！！！！！ */
            int begin = 0, end = arr.length - k;

            /** 尝试找leftbound的值 */
            while (begin < end) {

                int mid = begin + (end - begin) / 2;

                if (x - arr[mid] > arr[mid + k] - x) {   /** 这里的x是值，不是坐标!!! **/
                                                         /** 这里的close是指值的close **/
                                                         /** 题目要求是最close的距离**/   
                    begin = mid + 1;
                    
                } else {
                    
                    end = mid;
                }

            }

            int index = begin;

            /** 找到这K个点 */
            while (k != 0) {
                res.add(arr[index++]);
                k--;
            }
            return res;
        }
 
}
