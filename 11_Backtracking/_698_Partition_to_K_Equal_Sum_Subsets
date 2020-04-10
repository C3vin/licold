/** 小Fu讲解  https://www.youtube.com/watch?v=8XEcEYsG6Ck */
class Solution {

        int[] nums; 
        int target; 
    
        public boolean canPartitionKSubsets(int[] nums, int k) {

            /** 数组相加 */
            int sum = Arrays.stream(nums).sum();
 
            /** 边界条件，如果总和不能被K整除 */
            if (sum % k > 0) return false;

            /** 能分成几块 */
            int target = sum / k;

            /** array 排序 */
            Arrays.sort(nums);

            /** 拿到最大元素的坐标 */
            int R = nums.length - 1;

            /** 边界条件, 如果最大值，已经大于subSum*/
            if (nums[R] > target) return false;

            /** 把能单独 成为 subSum 的拿出来 */
            while (R >= 0 && nums[R] == target) {
                
                R--; // 最右边的坐标
                
                k--; // 
                
            }

            
            int[] bucket = new int[k];
            
            this.nums = nums; 
            this.target = target; 
            
            /** 开始战斗 */
            return partition(bucket, R);
        }

        /** 战场 --> backtrack */
        public boolean partition(int[] bucket /** 一共有多少组 */, int R) {

            /** 边界条件 */
            if (R < 0) return true;

            /** 拿出一个数 */
            int M = this.nums[R];

            /** 按照 现有组 来遍历 */
            for (int i = 0; i < bucket.length; i++) {

                            if (bucket[i] + M <= this.target) {

                                            bucket[i] += M;

                                            if (partition(bucket, R-1)) return true;

                                            bucket[i] -= M;
                            }

                            if (bucket[i] == 0) break;
            }
            
            return false;
        }
    
}