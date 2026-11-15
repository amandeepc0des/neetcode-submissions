class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char ch : s.toCharArray())
        {
            if(dq.size() == 0)dq.offerLast(ch);
            else if(dq.peekLast() == '(' && ch == ')')dq.pollLast();
            else if(dq.peekLast() == '{' && ch == '}')dq.pollLast();
            else if(dq.peekLast() == '[' && ch == ']')dq.pollLast();
            else dq.offerLast(ch);
        }
        return dq.isEmpty();
    }
}
