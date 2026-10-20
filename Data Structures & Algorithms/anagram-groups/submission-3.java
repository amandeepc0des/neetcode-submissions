class Solution {
    String getString(String temp)
    {
        int[] arr = new int[27];
        for(char it : temp.toCharArray())
        {
            arr[it - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for (int num : arr) {
            sb.append(num).append("#");
        }

        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> dict = new HashMap<>();
        for(int i = 0 ; i < strs.length; i++)
        {
            String key = getString(strs[i]);

            if(dict.containsKey(key))dict.get(key).add(strs[i]);
            else
            {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                dict.put(key, ls);
            }
        }

        List<List<String>> result = new ArrayList<>(dict.values());
        return result;
    }
}
