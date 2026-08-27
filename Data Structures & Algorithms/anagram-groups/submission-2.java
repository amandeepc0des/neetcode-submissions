class Solution {
    public String createAnagram(String str)
    {
        int[] curr = new int[26];
        for(char ch : str.toCharArray())curr[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int num : curr) {
            sb.append('#').append(num);
        }
        return sb.toString();

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> dict = new HashMap<>();
        for(int i = 0; i < strs.length; i++)
        {
            String key = createAnagram(strs[i]);
            if(!dict.containsKey(key))
            {
                dict.put(key, new ArrayList<>());
            }
            dict.get(key).add(strs[i]);
        }
        return new ArrayList<>(dict.values());
    }
}

