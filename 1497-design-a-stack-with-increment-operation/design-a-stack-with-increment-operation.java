class CustomStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int maxSize;
    public CustomStack(int maxSize) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(stack1.size() < maxSize) stack1.push(x);
    }
    
    public int pop() {
        return (stack1.isEmpty()) ? -1 : stack1.pop(); 
    }
    
    public void increment(int k, int val) {
        while(stack1.size() > k) stack2.push(stack1.pop());
        while(!stack1.isEmpty()) stack2.push(stack1.pop() + val);
        while(!stack2.isEmpty()) stack1.push(stack2.pop());
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */