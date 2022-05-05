class MyStack {
    Queue<Integer> stack;
    
    public MyStack() {
        this.stack = new LinkedList<>();
    }
    
    public void push(int x) {
        this.stack.add(x);
    }
    
    public int pop() {
        for (int i = 0; i < this.stack.size() - 1; i++) {
            this.stack.add(this.stack.poll());
        }
        return this.stack.poll();
    }
    
    public int top() {
        int peek = this.stack.peek();
        for (int i = 0; i < this.stack.size(); i++) {
            peek = this.stack.poll();
            this.stack.add(peek);
        }
        return peek;
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