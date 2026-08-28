class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, List<Integer>> dict = new HashMap<>();
        for(int item : nums)freq.put(item, freq.getOrDefault(item, 0) + 1);
        freq.forEach((K, v) -> 
        {
            if(!dict.containsKey(v))
            {
                dict.put(v, new ArrayList<>());
            }

            dict.get(v).add(K);
        });

        int j = 0;
        for(int i = nums.length; i >= 0; i--)
        {
            if(dict.containsKey(i))
            {
                for(int item : dict.get(i))
                {
                    result[j++] = item;
                    if(j == k)return result;
                }
            }

        }

        return new int[]{0};
    }
}
