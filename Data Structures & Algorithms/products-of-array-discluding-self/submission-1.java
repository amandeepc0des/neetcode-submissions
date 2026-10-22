class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];
        int n = nums.length;
        pre[0] = nums[0];
        suff[n - 1] = nums[n-1];
        for(int i = 1; i < n; i++)pre[i] = pre[i-1] * nums[i];
        for(int i = n - 2; i >=0; i--)suff[i] = suff[i + 1] * nums[i];
        int[] result = new int[n];
        for(int i = 1; i < n-1; i++)
        {
            result[i] = pre[i-1] * suff[i + 1];
        }
        result[0] = suff[1];
        result[n-1] = pre[n-2];
        return result;

    }
}  
