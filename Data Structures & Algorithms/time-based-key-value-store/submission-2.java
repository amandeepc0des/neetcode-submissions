class TimeMap {

    Map<String, List<String[]>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key))
        {
            mp.put(key, new ArrayList<>());
        }
        mp.get(key).add(new String[]{String.valueOf(timestamp), value});
    }
    
    public String get(String key, int timestamp) {
        
        if(!mp.containsKey(key))return "";
        int left = 0;
        int right = mp.get(key).size() - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            int midKey = Integer.parseInt(mp.get(key).get(mid)[0]);
            if(midKey == timestamp)return mp.get(key).get(mid)[1];
            else if(midKey < timestamp)left = mid + 1;
            else right = mid - 1;
        }
        // [1,2,3,5,6] 4 => 3
        if(right == -1)return "";
        return mp.get(key).get(right)[1];

    }
}

