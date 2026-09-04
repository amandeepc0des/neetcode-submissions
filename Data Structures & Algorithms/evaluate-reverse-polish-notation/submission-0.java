class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++)
        {
            String str = tokens[i];
            switch(str)
            {
                case "+" :
                {
                    int last1 = st.pollLast();
                    int last2 = st.pollLast();
                    st.offerLast(last1 + last2);
                    break;
                }
                case "-" :
                {
                    int last1 = st.pollLast();
                    int last2 = st.pollLast();
                    st.offerLast(last2 - last1);                    
                    break;
                }
                case "*" :
                {
                    int last1 = st.pollLast();
                    int last2 = st.pollLast();
                    st.offerLast(last1 * last2);                    
                    break;
                }
                case "/" :
                {
                    int last1 = st.pollLast();
                    int last2 = st.pollLast();
                    st.offerLast(last2 / last1);                    
                    break;
                }
                default :
                {
                    st.offerLast(Integer.parseInt(str));
                }
            }
        }
        return st.peekLast();
    }
}
