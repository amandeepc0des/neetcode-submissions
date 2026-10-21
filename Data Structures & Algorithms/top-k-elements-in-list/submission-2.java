class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[k];
        for(int it : nums)
        {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> ls = new ArrayList<>(mp.entrySet());
        ls.sort((a, b) -> b.getValue() - a.getValue());
        for(int i = 0; i < k; i++)
        {
            result[i] = ls.get(i).getKey();
        }

        return result;

    }
}
