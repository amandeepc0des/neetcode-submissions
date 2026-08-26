class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] map1 = new int[27];
        int[] map2 = new int[27];
        Arrays.fill(map1, 0);
        Arrays.fill(map2, 0);
        for(char ch : s.toCharArray())map1[ch - 'a']++;
        for(char ch : t.toCharArray())map2[ch - 'a']++;

        for(char ch : t.toCharArray())
        {
            if(map1[ch - 'a'] != map2[ch - 'a'])return false;
        }
        return true;

    }
}
