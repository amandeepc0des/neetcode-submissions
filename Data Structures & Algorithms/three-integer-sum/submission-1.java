class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i <= nums.length - 3; i++)
        {
            int j = i + 1;
            int k = nums.length - 1;
            int target = 0 - nums[i];
            while(j < k)
            {
                if(nums[j] + nums[k] == target)
                {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                }
                else if(nums[j] + nums[k] < target)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }
}
