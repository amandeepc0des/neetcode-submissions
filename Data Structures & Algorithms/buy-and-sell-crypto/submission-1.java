class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            maxProfit = Math.max(maxProfit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}
