class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())return false;
        int[] mp1 = new int[27];
        int[] mp2 = new int[27];
        for(char it : s1.toCharArray())mp1[it - 'a']++;
        int left = 0;
        int right = 0;
        while(right < s2.length())
        {
            char ch = s2.charAt(right);
            mp2[ch - 'a']++;
            boolean bp = true;
            if(right - left + 1 == s1.length())
            {
                for(int i = 0; i <= 26; i++)
                {
                    if(mp1[i] != mp2[i])
                    {
                        bp = false;
                        break;
                    }
                }
                if(bp)return true;
                mp2[s2.charAt(left++) - 'a']--;
            }
            right++;
        }

        return false;
    }
}
