class Solution {
    
        public int threeSumClosest(int[] numbers, int target) {

            if(numbers == null || numbers.length == 0) return Integer.MAX_VALUE;

            Arrays.sort(numbers);

            int diff = Integer.MAX_VALUE;

            for(int i = 0; i < numbers.length - 2; i++) {

                    int tar = target - numbers[i];
                                                          /* End */  
                    int distance = explore(numbers, i+1, numbers.length - 1,      tar);

                    if( Math.abs(distance) < Math.abs(diff) ) diff = distance;                 
            }
            
            return (target - diff);
       }
    
       private int explore(int[] num, int start, int end, int target) {

            int difference = Integer.MAX_VALUE;

            while(start < end) {

                int sum = num[start] + num[end];

                if(sum == target) return 0;
                  
                if( Math.abs(difference) > Math.abs(target - sum) ) difference = target - sum;
    
                if(sum < target) start++;
                else end--;
             
            }
           
            return difference;
     }           
}

