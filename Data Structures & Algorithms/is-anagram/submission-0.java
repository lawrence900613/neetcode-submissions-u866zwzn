class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            Map<Character, Integer> hashMap1 = new HashMap<Character, Integer>();
            Map<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                if(hashMap1.containsKey(s.charAt(i))) {
                    hashMap1.put(s.charAt(i), hashMap1.get(s.charAt(i)) + 1);
                } else {
                    hashMap1.put(s.charAt(i), 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if(hashMap2.containsKey(t.charAt(i))) {
                    hashMap2.put(t.charAt(i), hashMap2.get(t.charAt(i)) + 1);
                } else {
                    hashMap2.put(t.charAt(i), 1);
                }
            }
            return hashMap1.equals(hashMap2);
        }
    }
}
