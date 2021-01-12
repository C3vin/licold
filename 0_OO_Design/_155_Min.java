class MinStack {

    Stack<Integer> stack; 
    int min; 
    
    /** initialize your data structure here. */
    public MinStack() {
        
        stack = new Stack<>(); 
        
        min = Integer.MAX_VALUE; 
    }
    
    public void push(int x) {
     
        if( x <= min ){
            
            stack.push(min); 
            stack.push(x); 
            
            min = x; 
            
        } else {
             
           stack.push(x);
        }
         
    }
    
    public void pop() {
        
        int peek = stack.pop(); 
        
        if(peek == min){
            
            min = stack.pop(); 
        }
        
    }
    
    public int top() {
        
        return stack.peek(); 
    }
    
    public int getMin() {
        
        return min; 
    }
}
 