class Solution {
 
    public List<List<Integer>> threeSum(int[] nums) {
       
        /** 1. 製造結果集  **/
        List<List<Integer>> res = new ArrayList<>();

        /** 2. 排序 **/
        Arrays.sort(nums);

        /** 3. base指針，遍歷 sums，確保 後面還有 2個 （前面遍歷的算一個，總共1+2，是3個）**/
        for (int i = 0; i < nums.length - 2; i++) {
                /** 3.1 排除重複的  **/
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                /** 3.2 設置左右pointer  **/
                int low = i + 1, high = nums.length - 1;
                /** 3.3 製造降維的 target  **/
                int sum = 0 - nums[i];
                /** 3.4 掃描指針 **/
                while (low < high) {
                        /** 3.5 撞到答案  **/
                        if (nums[low] + nums[high] == sum) {
                            /** ~1 加入答案  **/
                            res.add(   Arrays.asList( nums[i], nums[low], nums[high] )   );
                            /** ~2 Skip重複的元素  **/
                            while ( low < high && nums[low] == nums[low + 1]) low++;
                            while ( low < high && nums[high] == nums[high - 1]) high--;
                            /** ~3 收緊pointer  **/
                            low++;
                            high--;
                        /** 如果沒撞到，移動指針 **/
                        } else if (nums[low] + nums[high] < sum) {
                            low++;
                        } else {
                            high--;
                        }
                }
        }
        return res;
    }
}

