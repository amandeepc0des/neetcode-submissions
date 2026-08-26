class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Pair<Integer, Integer>> ls = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            Pair<Integer, Integer> p = new Pair(i, nums[i]);
            ls.add(p);
        }
        ls.sort((a, b) -> Integer.compare(a.val, b.val));
        int i = 0;
        int j = nums.length - 1;
        while(i < j)
        {
            int ind1 = ls.get(i).ind;
            int val1 = ls.get(i).val;
            int ind2 = ls.get(j).ind;
            int val2 = ls.get(j).val;
            if(val1 + val2 == target)return new int[]{Math.min(ind1, ind2), Math.max(ind1, ind2)};
            else if(val1 + val2 < target)i++;
            else j--;
        }

        return new int[]{0,0}; 
        
    }
}

class Pair<K,V>
{
    K ind;
    V val;

    Pair(K ind, V val)
    {
        this.ind = ind;
        this.val = val;
    }
}
