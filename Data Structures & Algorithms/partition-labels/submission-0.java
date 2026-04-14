class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        List<Integer> ret = new ArrayList<>();
        int size = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            size += 1;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            
            if(i == end) {
                ret.add(size);
                size = 0;
            }
        }

        return ret;
    }
}
