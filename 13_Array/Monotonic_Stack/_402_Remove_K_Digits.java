public class Solution {
    
    public String removeKdigits(String num, int k) {
        
        int len = num.length();
        
        //corner case
        if(k==len) return "0";
            
        Stack<Character> stack = new Stack<>();
        
        int i =0;
        
        while(i<num.length()){  //单调栈
             
            /* 只要k大于0，栈不是空的，并且，栈顶比当前的大 --> 就弹出栈顶，k减一 */
            while( k>0 && !stack.isEmpty() && num.charAt(i) < stack.peek() ){
                
                stack.pop();
                
                k--;
            }
            
            stack.push(num.charAt(i));
            
            i++;
        }
        
        /* 边界情况，当k仍然大于零，则是这个情况 "1 1 1 1 5 9" */
        while(k>0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution {  // 也是单调栈思路但，是StringBuilder做的
    public String removeKdigits(String num, int k) {
        
        if (k==num.length()) return "0";
        
        StringBuilder str = new StringBuilder();
        
        for (char i:num.toCharArray()){
 
            while (str.length()>0 && k>0 && str.charAt(str.length()-1)>i){
                
                str.deleteCharAt(str.length()-1);
                k--;
                
            }
            
            str.append(i);
        }
        
        int i=0; // 处理leading 0 比如  002345 前面的0要除掉
        
        while( i < ( str.length()-1-k )  && str.charAt(i)=='0') i++;
        
        return str.substring(i, str.length()-k);
    }
}


