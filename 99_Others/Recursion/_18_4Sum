class Solution {

        int len = 0;

        /** 主函數  **/
        public List<List<Integer>> fourSum(int[] nums, int target) {

            /** 1. nums的長度  **/
            len = nums.length;

            /** 2. 排序  **/
            Arrays.sort(nums);

            /** 3. 正式開戰  **/
            return kSum(nums, target, 4, 0);
        }

        /** 3. 正式開戰  **/
        private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {

            /** 1. 制造結果集  **/
            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

            /** 2. 邊界條件  **/
            if(index >= len) return res;

            /** 3. 如果是 2Sum  **/
            if(k == 2) {

                int i = index, j = len - 1;  /* 左右边界 */

                while(i < j) {

                    //find a pair
                    if( nums[i] + nums[j] == target ) {

                        List<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);

                        temp.add(nums[j]);

                        res.add(temp);

                        //skip duplication
                        while(i<j && nums[i]==nums[i+1]) i++;
                        while(i<j && nums[j-1]==nums[j]) j--;

                        i++;
                        j--;
                        //move left bound

                    } else if (target - nums[i] > nums[j]) {
                        i++;
                        //move right bound
                    } else {
                        j--;
                    }
                }

            /** 4. 如果 k 大於 2  **/
            } else{

                                    /** 為何要減去k，因為從後面找 (k - 1) 個元素 | 前面是一個 base 指針 **/
                
                                    for (int i = index; i < len - (k - 1); i++) {

                                                // private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {

                                                /** ~1 降維  **/
                                                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);

                                                if(temp != null){

                                                    for (List<Integer> t : temp) t.add(0, nums[i]);
                                                     
                                                    res.addAll(temp); /* 加入所有元素 */
                                                }

                                                /** ~ Skip 重複的  **/
                                                while (i < len-1 && nums[i] == nums[i+1]) i++;             
                                  }
                                  
                                  /* 这里解释一下， 
                                     
                                     1. 比如  -7 -3 -1 0 2 5 9 11
                                     2. 第一层，K=4，那么右边界是2，只能找到2位置，剩余3个
                                     3. 第二层，假如我从-3进入，K=3  那么有边界是5，剩余2个
                                     4. 第三层，假如我从0进入，K=2, 好了！ 现在进入two sum了！不用考虑边界问题了 
                                  
                                  */
                                  
                                  
            }
            
            return res;
        }
}
