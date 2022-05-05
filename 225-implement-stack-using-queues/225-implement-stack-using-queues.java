class MyStack {
    Queue<Integer> stack;
    
    public MyStack() {
        this.stack = new LinkedList<>();
    }
    
    public void push(int x) {
        this.stack.add(x);
        for (int i = 0; i < this.stack.size() - 1; i++) {
            this.stack.add(this.stack.poll());
        }
    }
    
    public int pop() {
        return this.stack.poll();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public boolean empty() {
        return this.stack.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */