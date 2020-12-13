class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public MinStack() {
    }
    
    public void push(int x) {
       stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
        {
            minStack.push(x);        
        }    
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return minStack.peek();
    }
}
