public class Solution {
    
    public int calculate(String s) {
        
        int len;
        if(s==null || (len = s.length())==0) return 0;
        
        Deque<Integer> stack = new LinkedList<Integer>();
        
        int num = 0;
        char sign = '+';
        
        for(int i=0;i<len;i++){
            
            if(  Character.isDigit( s.charAt(i) )  )  num = num*10 + s.charAt(i) - '0';
             
            if(  ( !Character.isDigit( s.charAt(i) ) &&' '!=s.charAt(i) ) || i==len-1 ) {
                
                // 注意: 这里的sign是上辈子的!!!!!!!
                if(sign=='-')  stack.addFirst(-num);
                 
                if(sign=='+')  stack.addFirst(num);
                 
                if(sign=='*')  stack.addFirst(stack.removeFirst()*num);
                
                if(sign=='/')  stack.addFirst(stack.removeFirst()/num);
                
                // 注意: 这里的sign是这辈子的!!!!!!!
                sign = s.charAt(i);
                
                num = 0;
            }
        }

        int re = 0;
        
        for(int i:stack) re += i;
         
        return re;
    }
}