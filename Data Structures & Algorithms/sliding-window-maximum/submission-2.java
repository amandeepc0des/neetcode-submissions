class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0, right = 0, i = 0;

        while (right < nums.length) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }
            dq.offerLast(right);
            if (right - left + 1 == k) {
                res[i++] = nums[dq.peekFirst()];

                if (dq.peekFirst() == left) {
                    dq.pollFirst();
                }
                left++;
            }

            right++;
        }

        return res;
    }
}
