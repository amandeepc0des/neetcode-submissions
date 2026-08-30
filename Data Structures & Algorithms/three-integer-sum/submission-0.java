class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> triplets = new HashSet<>();
        for(int i = 0; i <= len - 3; i++)
        {
            int j = i + 1;
            int k = len - 1;
            int target = 0 - nums[i];
            while(j < k)
            {
                int res = nums[j] + nums[k];
                if(res == target)
                {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                }
                else if(res > target)
                {
                    k--;
                }
                else 
                {
                    j++;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(triplets);
        return ans;
    }
}
