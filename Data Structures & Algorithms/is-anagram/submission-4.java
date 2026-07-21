class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < length; i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        } 
        for(Map.Entry<Character, Integer>entry: map1.entrySet()) {
            if(!map2.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
