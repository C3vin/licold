class CustomStack {

    int n;
    int[] increment;
    
    Stack<Integer> stack;
    
    public CustomStack(int maxSize) {
        
        n = maxSize;
        
        increment = new int[n];
        
        stack = new Stack<>();
        
    }

    public void push(int x) {
        if (stack.size() < n) stack.push(x);
    }

    public void increment(int k, int val) {
        
        int i = Math.min(k, stack.size()) - 1;
        
        if (i >= 0) increment[i] += val;                // 增量array
    }
    
    public int pop() {
        
        int i = stack.size() - 1;
        
        if (i < 0) return -1; //  空的, 返回-1
        
        if (i == 0) ;         //  当前就剩一个，跳下一步
        
        if (i > 0)  increment[i - 1] = increment[i - 1] + increment[i];   
        
        int res = stack.pop() + increment[i];
        
        increment[i] = 0;
        
        return res;
    }


}