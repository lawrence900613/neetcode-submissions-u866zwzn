class TimeMap {
    HashMap<Pair<String, Integer>, String> mapForValue;
    HashMap<String, List<Integer>> mapForTimeStamp;
    public TimeMap() {
        mapForValue = new HashMap<Pair<String, Integer>, String>();
        mapForTimeStamp = new HashMap<String, List<Integer>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!mapForTimeStamp.containsKey(key)) {
            mapForTimeStamp.put(key, new ArrayList<>(Arrays.asList(timestamp)));
        } else {
            mapForTimeStamp.get(key).add(timestamp);
        }
        Pair<String, Integer> newPair = new Pair<String, Integer>(key, timestamp);
        mapForValue.put(newPair, value);
    }
    
    public String get(String key, int timestamp) {
        if (!mapForTimeStamp.containsKey(key)) {
            return "";
        }
        List<Integer> list = mapForTimeStamp.get(key);
        int left = 0;
        int right = list.size() - 1;
        int ans = -1; 
        while (left <= right) {
            int mid = left + (right - left)/2;
            int time = list.get(mid);
            if (time <= timestamp) {
                ans = Math.max(time, ans);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (ans == -1) {
            return "";
        } else {
            return mapForValue.get(new Pair<String, Integer>(key, ans));
        }
    } 
}
