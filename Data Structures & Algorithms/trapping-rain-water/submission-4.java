class Solution {
    public int trap(int[] height) {
        int right = 0;
        int left = 1;
        int area = 0;
        while(left < height.length)
        {
            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                for(int i = right; i <= left; i++)
                {
                    area += Math.max(0, height[right] - height[i]);
                }

                right = left;
                left++;
            }

        }
        left = height.length - 1;
        right = left - 1;
        while(right >= 0)
        {
            if(height[right] <= height[left])
            {
                right--;
            }
            else
            {
                for(int i = left; i >= right; i--)
                {
                    area += Math.max(0, height[left] - height[i]);
                }

                left = right;
                right--;
            }
        }
        return area;
    }
}
