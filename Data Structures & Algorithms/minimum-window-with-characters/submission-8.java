class Solution {
    boolean isPresent(Map<Character, Integer> tMap, Map<Character, Integer> sMap)
    {
        for(Map.Entry<Character, Integer> entry : tMap.entrySet())
        {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if(!sMap.containsKey(key))return false;
            if(sMap.get(key) < val) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char it : t.toCharArray())
        {
            tMap.put(it, tMap.getOrDefault(it, 0) + 1);
        }
        int lAns = -1;
        int rAns = -1;
        int min = Integer.MAX_VALUE;
        while(right < s.length())
        {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            right++;
            while(isPresent(tMap, sMap))
            {
                if(right - left + 1 < min)
                {
                    min = right - left + 1;
                    lAns = left;
                    rAns = right;
                }
                sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

        }

        if(lAns == -1)return "";
        return s.substring(lAns, rAns);
    }
}
