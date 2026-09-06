class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] preSmall = new int[len];
        int[] nextSmall = new int[len];

        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < len; i++)
        {
            while(!st.isEmpty() && heights[st.peekLast()] >= heights[i])st.pollLast();
            if(st.isEmpty())preSmall[i] = -1;
            else preSmall[i] = st.peekLast();
            st.offerLast(i);
        }

        st.clear();

        for(int i = len - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[st.peekLast()] >= heights[i])st.pollLast();
            if(st.isEmpty())nextSmall[i] = len;
            else nextSmall[i] = st.peekLast();
            st.offerLast(i);
        }
        
        int result = 0;
        for(int i = 0; i < len; i++)
        {   
            int last = preSmall[i] + 1;
            int next = nextSmall[i] - 1;
            result = Math.max(heights[i], Math.max(result,  (next - last + 1) * heights[i]));
        }

        return result;
    }
}
