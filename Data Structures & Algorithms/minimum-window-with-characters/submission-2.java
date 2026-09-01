class Solution {
    
    boolean isValid(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char key = entry.getKey();
            if (!sMap.containsKey(key) || sMap.get(key) < tMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char key : t.toCharArray())tMap.put(key, tMap.getOrDefault(key, 0) + 1);
        int left = 0;
        int right = 0;
        int ind1 = -1;
        int ind2 = -1;
        int mini = Integer.MAX_VALUE;
        while(right < s.length())
        {
            while(right < s.length() && !isValid(sMap, tMap))
            {
                char key = s.charAt(right++);
                sMap.put(key, sMap.getOrDefault(key, 0) + 1);
                //System.out.println("left: " + left + " right: " + right);
            }

            while(isValid(sMap, tMap))
            {
                char key = s.charAt(left);
               // System.out.println("left: " + left + " right: " + right);
                if(mini > right - left + 1)
                {
                    mini = right - left + 1;
                    ind1 = left;
                    ind2 = right;
                }
                left++;
                sMap.put(key, sMap.getOrDefault(key, 0) - 1);
                //System.out.println("ind1: " + ind1 + " ind2: " + ind2);
            }
        }

        if(mini == Integer.MAX_VALUE)return "";
        return s.substring(ind1, ind2);
    }
}
