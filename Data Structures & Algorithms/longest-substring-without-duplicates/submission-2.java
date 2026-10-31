class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int left = 0;
        int res = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(left < s.length())
        {
            char curr = s.charAt(left);
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
            if(mp.get(curr) > 1)
            {
                while(mp.get(curr) > 1)
                {
                    char curr1 = s.charAt(right);
                    mp.put(curr1, mp.getOrDefault(curr1, 0) - 1);
                    right++;
                }
            }
            res = Math.max(res, left - right + 1);
            left++;
        }
        return res;

    }
}
