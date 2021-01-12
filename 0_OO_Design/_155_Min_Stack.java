class MinStack{
    
    //  https://www.youtube.com/watch?v=WxCuL3jleUA 	

    Stack<Integer> stack = new Stack();
    Stack<Integer> min_vals = new Stack();
    
    public void push(int x) {
        
        if( min_vals.isEmpty() || x <= min_vals.peek() ) {
            min_vals.push(x);
        }
        
        stack.push(x); 
    }
    
    public void pop() {
        if(stack.peek().equals(min_vals.peek())) {
            min_vals.pop();
        }
        
        stack.pop();
    }
    
    public int top(){
        return stack.peek();
    }
    
    public int getMin() {
        return min_vals.peek();
    }
}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

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
 