class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right])left = mid + 1;
            else right = mid; 
            // here we are trying to shrink the array in that half where the min can exist.
        }
        return nums[left]; // because it will be the first elemen of that sorted half.
    }
}
