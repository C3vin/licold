class Solution {
 
    public int calculate(String s) {
        
        if(s == null) return 0;

        int result = 0;
        
        int sign = 1;   // 1 means "+",  -1 means "-"
        int num = 0;

        Deque<Integer> stack = new LinkedList<Integer>();
        
        stack.addFirst(sign);

        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if(c == '+' || c == '-') {
                
                result += sign * num;
                sign = stack.peekFirst() * (c == '+' ? 1: -1); 
                num = 0;

            } else if(c == '(') {
                stack.addFirst(sign);

            } else if(c == ')') {
                stack.removeFirst();
            }
        }

        result += stack.peekFirst() * sign * num;   //  
        
        //  stack.peekFirst() 这里是大环境。
        //  这一步是把 基础大环境 1 拿出来，所以说要不要无所谓，本来就是1
    
        return result;
    }
}