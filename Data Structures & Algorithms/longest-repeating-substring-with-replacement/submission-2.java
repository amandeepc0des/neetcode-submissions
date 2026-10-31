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
            while(right - left + 1 - maxFreq > k)
            {
                mp[s.charAt(left++) - 'A']--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}


// pattern :  Perform the opration untill the window is valid, once you see the window is not valid move the left pointer.
// in the case, the validity is "right - left + 1 - maxFreq <= k" 
// if the remaining character other then the max charaters are less than or equal to k
// we can replace with the max and that window will be ans. 