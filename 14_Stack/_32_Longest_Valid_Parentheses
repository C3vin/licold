class Solution {
    
    /*
      
      Tutorial: https://www.youtube.com/watch?v=M1Vw5Tk1rw4 
       
    */
    
    public int longestValidParentheses(String s) {
        
            /* Initiate the answer value */
            int ans = 0;
            
            Stack<Integer> stack = new Stack<>();
            
            stack.push(-1);
 
            /* Scan */
            for (int i = 0; i < s.length(); i++) {

                /* if ( */
                if (s.charAt(i) == '(') {

                    stack.push(i);

                /* if ) */    
                } else {

                    /* pop the element */
                    stack.pop();

                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        ans = Math.max(ans, i - stack.peek());
                    }
                    
                }
                
            }
            return ans;
    }
    
}
