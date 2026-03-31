class MinStack {
    PriorityQueue<Integer> queue;
    Stack<Integer> stack;
    public MinStack() {
        queue =  new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        queue.add(val);
        stack.push(val);
    }
    
    public void pop() {
        int element = stack.pop();
        queue.remove(element);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}
