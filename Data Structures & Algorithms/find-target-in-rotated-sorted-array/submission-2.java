class Solution {
    public int search(int[] nums, int target) {
        // in this question also we can use the same patter as we used in find min in RSA. // check which half is sorted, if the target lies in that half, update the right and left accordingly until we get.

        int left = 0;
        int right = nums.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)return mid;
            else if(nums[mid] > nums[right])
            {
                if(target >= nums[left] && target < nums[mid])right = mid - 1;
                else left = mid + 1;
            }
            else{
                if(target > nums[mid] && target <= nums[right])left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
