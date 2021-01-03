class Solution {
    
    public int calculate(String s) {

        int len; 
        
        if(s==null || (len = s.length())==0) return 0; 
        
        Deque<Integer> stack = new LinkedList<Integer>(); 
        
        int num = 0; 
        
        char sign = '+';
        
        char curr = ' '; 
        
        for(int i = 0; i < len; i++){
            
            curr = s.charAt(i); 
            
            if( Character.isDigit( curr ) ) num = num*10 + curr - '0'; 
            
            if( !Character.isDigit( curr ) && curr != ' ' || (i == len - 1) ){
                  
                if(sign == '-') stack.addFirst(-num); 
                
                if(sign == '+') stack.addFirst(num);
                
                if(sign == '*') stack.addFirst(stack.removeFirst() * num);
                
                if(sign == '/') stack.addFirst(stack.removeFirst() / num);                 
                
                sign = s.charAt(i); 
                
                num = 0; 
                 
            }
             
        }
         
        int re = 0; 
               
        for( int i : stack ) re += i; 
               
        return re;    
    }
}