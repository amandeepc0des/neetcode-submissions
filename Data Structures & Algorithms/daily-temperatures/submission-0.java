class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];
        Arrays.fill(result, 0);
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < temp.length; i++)
        {
            while(!st.isEmpty() && temp[st.peekLast()] < temp[i])
            {
                result[st.peekLast()] = i - st.peekLast();
                st.pollLast();
            }
            st.offerLast(i);

        }
        return result;
    }
}
