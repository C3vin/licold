public class Solution {
    
    public String removeKdigits(String num, int k) {
        
        int len = num.length();
         
        if(k==len) return "0";  //corner case
            
        Deque<Character> deque = new ArrayDeque<>();
        
        int i =0;
        
        while(i<num.length()){  //单调栈
             
            /* 只要k大于0，栈不是空的，并且，栈顶比当前的大 --> 就弹出栈顶，k减一 */
            while( k>0 && !deque.isEmpty() && num.charAt(i) < deque.peek() ){
                
                deque.removeFirst();
                k--;
            }
            
            deque.addFirst(num.charAt(i));
            i++;
        }
        
        /* 边界情况，当k仍然大于零，则是这个情况 "1 1 1 1 5 9" */
        while(k>0){
            deque.removeFirst();
            k--;            
        }
 
        StringBuilder sb = new StringBuilder();
        
        while(!deque.isEmpty()) sb.append(deque.removeLast());
         
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        
        return sb.toString();
    }
}