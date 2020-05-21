class Solution {

    int count = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
    
        int L = nums.length; 
        
        if( (L == 0 && S != 0) || (nums == null && S != 0)  ) return 0; 
    
        int index = 0;
        
        helper(nums, L, index, 0, S); 
        
        return count;
    }
     
    public void helper(int[] nums, int L, int index, int curSum, int S){
        
        if(index == L) return; 
         
        int cur = nums[index];
        
        int Add = curSum + cur;
        int Minus = curSum - cur;
 
        if(index == L - 1 && Add == S) count++; 
        if(index == L - 1 && Minus == S) count++;         
       
        index++; 
        
        helper(nums, L, index, Add, S); 
        helper(nums, L, index, Minus, S); 
    }
}