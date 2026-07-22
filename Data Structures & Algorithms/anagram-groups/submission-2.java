class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for(String s: strs) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            for(Character c: s.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            List<String> toAdd = map.getOrDefault(count, new ArrayList<>());
            toAdd.add(s);
            map.put(count, toAdd);
        }
        return new ArrayList<>(map.values());
    }
}
