class Solution {
  
    public int[] moveZeroes(int[] nums) {

            int iPointer = 0;
            int len = nums.length;

            for(int i=0; i<len;++i)
            {
                if(nums[i] != 0)
                    nums[iPointer++] = nums[i];//直接将遇到的非0元素
            }

            if(iPointer != 0)
            {
                for(; iPointer<len; iPointer++)
                    nums[iPointer] = 0;
            }

        return nums;
        
        }
}