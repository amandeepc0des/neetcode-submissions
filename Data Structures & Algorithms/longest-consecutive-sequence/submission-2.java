class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int item : nums)mp.put(item, mp.getOrDefault(item , 0) + 1);
        int maxi = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int key = nums[i];
            if(mp.containsKey(key - 1))continue;
            int cnt = 0;
            while(mp.containsKey(key))
            {
                cnt++;
                key++;
            }
            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
    
}
