class MinStack {

    Deque<Integer> st1;
    Deque<Integer> st2;

    public MinStack() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st1.offerLast(val);
        if(st2.isEmpty())st2.offerLast(val);
        else
        {
            if(st2.peekLast() >= val)st2.offerLast(val);
        }
    }
    
    public void pop() {
        if(st1.peekLast().equals(st2.peekLast()))
        {
            st2.pollLast();
        }
        st1.pollLast();
    }
    
    public int top() {
        return st1.peekLast();
    }
    
    public int getMin() {
        return st2.peekLast();
    }
}
