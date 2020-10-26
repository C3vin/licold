public class Solution {
    
    public int calculate(String s) {
        
        int len = s.length();
        
        if( s == null || len == 0 ) return 0;
        
        Deque<Integer> stack = new LinkedList<Integer>();
        
        //////////////////////////////////////////////////
        //////////////////////////////////////////////////
        //////////////////////////////////////////////////
        
        int num = 0;
        
        char sign = '+';
        
        //  33 + 13/5 - 4 * 3
         
        for( int i = 0; i < len; i++ ){
            
            if(  Character.isDigit( s.charAt(i) )  )  num = num*10 + s.charAt(i) - '0';
             
            if(  (    !Character.isDigit( s.charAt(i) ) && ' '!=s.charAt(i)    )   ||   i==len-1   ) {
                
                if(sign=='-')  stack.addFirst(-num);
                 
                if(sign=='+')  stack.addFirst(num);
                 
                if(sign=='*')  stack.addFirst(stack.removeFirst()*num);
                
                if(sign=='/')  stack.addFirst(stack.removeFirst()/num);
                
                sign = s.charAt(i);
                
                num = 0;
            }
        }

        int res = 0;
        
        for(int i:stack) res += i;
         
        return res;
    }
}