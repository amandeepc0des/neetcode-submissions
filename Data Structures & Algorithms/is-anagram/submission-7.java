class Solution {
    public boolean isAnagram(String s, String t) {
            // int result = 0;
            // for(char it : s.toCharArray())
            // {
            //     result ^= (it - 'a') + 1;
            // }

            // for(char it : t.toCharArray())
            // {
            //     result ^= (it - 'a') + 1;
            // }

            // return result == 0;
            // The above apporach won't work because all character or s can make the result 0 and same with t.

            if(s.length() != t.length())return false;
            HashMap<Character, Integer> sMap = new HashMap<>();
            HashMap<Character, Integer> tMap = new HashMap<>();

            for(char it : s.toCharArray())sMap.put(it, sMap.getOrDefault(it, 0) + 1);
            for(char it : t.toCharArray())tMap.put(it, tMap.getOrDefault(it, 0) + 1);

            for(char it : s.toCharArray())
            {
                if(!sMap.get(it).equals(tMap.get(it)))return false;
            }
            return true;
    }
}
