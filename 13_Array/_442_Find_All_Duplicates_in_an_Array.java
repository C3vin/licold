class Solution {
    
    // 注意这题输入都是正数，并且  1 ≤ a[i] ≤ n (n = size of array) 
    // 这题自己用草稿纸跑一遍就懂了
    // iPad pro 录了视频
    
    public List<Integer> findDuplicates(int[] nums) {
 
            /** 1. 製造答案集 **/
            List<Integer> res = new ArrayList<>();

            /** 2. 邊界條件  **/
            if (nums == null || nums.length == 0) return res;

            /** 3. 遍歷  **/
            for (int i = 0; i < nums.length; i++) {

                    /** 3.1 獲取這個數，對應的 index **/  /** 為何減 1 ?  不減也可以，但要加多一個字符的空間，space受損**/
                    // 这里可以减一，因为元素最长可以是n，最小可以是1
                    int index = Math.abs(nums[i]) - 1;

                    /** 3.2 如果這個index，已經被檢查過，加入 index  **/
                    if (nums[index] < 0) {

                        /**   **/
                        res.add( index + 1 );
                    }

                    /** {4,3,2,*7,8,2,3,1} **/

                    nums[index] = -nums[index];
            }
        
            return res;
    }
}