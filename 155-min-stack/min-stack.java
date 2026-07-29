class MinStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int min;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        stack1.push(value);
        min = Math.min(min, value);
    }
    
    public void pop() {
        int element = stack1.pop();
        if(element == min) {
            min = Integer.MAX_VALUE;
            while(!stack1.isEmpty()) {
                int ele = stack1.pop();
                min = Math.min(ele, min);
                stack2.push(ele);
            }
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */