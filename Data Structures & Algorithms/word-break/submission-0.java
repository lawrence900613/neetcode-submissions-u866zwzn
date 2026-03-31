class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        map.put(s.length(), true);
        return dfs(s, wordDict, 0, map);
    }

    private boolean dfs(String s, List<String> wordDict, int i, HashMap<Integer, Boolean> map) {
        if (map.containsKey(i)) {
            return map.get(i);
        }

        for (String w : wordDict) {
            if (i + w.length() <= s.length() &&
                s.substring(i, i + w.length()).equals(w)) {
                if (dfs(s, wordDict, i + w.length(), map)) {
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    }
}
