class Solution {
    
    //O(n) --> Not in place
    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums); 
        
        int N = nums.length; 
        
        int[] temp = new int[N]; 
        
        // Copy the input
        for(int i = 0; i<N; i++) temp[i] = nums[i];
        
        // make two pointer
        int left = (N+1)/2; 
        int right = N; 
        
        for(int i = 0; i < N; i++){
            nums[i] = i % 2 == 1 ? temp[--right] : temp[--left]; 
        }
         
        
    }
    
}