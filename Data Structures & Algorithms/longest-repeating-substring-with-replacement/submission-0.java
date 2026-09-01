class Solution {
    public int characterReplacement(String s, int k) {
        int[] mp = new int[26];
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length())
        {
            mp[s.charAt(right) - 'A']++;
            int maxFreq = 0;
            for(int x : mp)maxFreq = Math.max(maxFreq, x);
            if(right - left + 1 - maxFreq > k)
            {
                mp[s.charAt(left++) - 'A']--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
