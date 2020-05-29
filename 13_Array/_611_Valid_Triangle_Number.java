public class Solution {
  
        public int triangleNumber(int[] nums) {
             
            int n = nums.length; 
            if( n < 3 ) return 0;       // 1. 边界条件
            Arrays.sort(nums);      // 2. 升序
      
            reverse(nums, n);        // 3. 变成降序!! (如果不变, 这里的Binary Search要重写)
            int count = 0;               // 4. 初始化返回结果
 
            for(int a = 0 ; a < n - 2 ; ++a) {   // 5. 从 0 到 n-2 
      
                int b = a + 1; 					      // 6. 初始化 b, c
                
                int c = n - 1; 
  
                while( b < c ){					      // 7. 二分法
                     
                        if( nums[b] + nums[c] > nums[a] ) {    // 满足三角形的条件
                        
                            count += ( c-b ); 
                            ++b; 
                        } else  --c; 
                }
            }  
            return count;
        }
     
        public int[] reverse(int[] nums, int n){   // 工具函数    
            
            int hi = n-1;
            int lo = 0; 
            
            while(lo<=hi){
                
                int tmp = nums[lo]; 
                nums[lo] = nums[hi]; 
                nums[hi] = tmp; 
 
                lo++;
                hi--;
            } 
            return nums; 
        }
}
