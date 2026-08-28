class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] suff = new int[len];
        pre[0] = nums[0];
        suff[len - 1] = nums[len - 1];
        for(int i = 1; i < len; i++)pre[i] = pre[i - 1] * nums[i];
        for(int i = len - 2; i >= 0; i--)suff[i] = suff[i + 1] * nums[i];
        int[] result = new int[len];

        result[0] = suff[1];
        result[len - 1] = pre[len - 2];
        for(int i = 1; i < len - 1; i++)
        {
            result[i] = pre[i - 1] * suff[i + 1];
        }
        return result;
    }
}  
