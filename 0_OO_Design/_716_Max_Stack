class MaxStack {

            // https://youtu.be/y7T00suWkrY?t=15 
       
            Stack<Integer> stack;
            Stack<Integer> maxStack;

            public MaxStack() {
                stack = new Stack();
                maxStack = new Stack();
            }

            public void push(int x) {
                int max = maxStack.isEmpty() ? x : maxStack.peek();
                maxStack.push(max > x ? max : x);
                stack.push(x);
            }

            public int pop() {
                maxStack.pop();
                return stack.pop();
            }

            public int top() {
                return stack.peek();
            }

            public int peekMax() {
                return maxStack.peek();
            }

            public int popMax() {

                int max = peekMax();

                Stack<Integer> buffer = new Stack();

                while (top() != max) buffer.push(pop());    /** 先把max之前的東西拿出來 **/

                pop();

                while (!buffer.isEmpty()) push(buffer.pop());  /** 再把max之前的東西放進去  **/

                return max;
            }
}