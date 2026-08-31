class Solution {
    public int maxArea(int[] heights) {
        int maxi = 0;
        int right= 0;
        int left = heights.length - 1;
        while(right < left)
        {
            maxi = Math.max(maxi, Math.min(heights[right], heights[left]) * (left - right));
            if(heights[right] > heights[left])left--;
            else right++;
        }
        return maxi;
    }
}
