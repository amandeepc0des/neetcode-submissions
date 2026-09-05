
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(arr, (a, b) -> Double.compare(a[1], b[1]));

        Deque<double[]> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            double pos = arr[i][0];
            double time = arr[i][1];

            if (st.isEmpty()) {
                st.push(new double[]{pos, time});
            } else {
                double[] top = st.peek();
                if (time < top[1] && pos > top[0]) {
                    st.push(new double[]{pos, time});
                } else {
                    st.pop();
                    st.push(new double[]{Math.max(pos, top[0]), Math.max(time, top[1])});
                }
            }
        }

        return st.size();
    }
}
