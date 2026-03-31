class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int left = 0;
        int right = 0;
        int max = 0;
        List<Character> queue = new ArrayList<Character>();
        while (right < s.length()) {
            if(queue.contains(s.charAt(right))) {
                left += 1;
                queue.remove(0);
            } else {
                queue.add(s.charAt(right));
                max = Math.max(max, queue.size());
                right += 1;
            }
        }
        return max;
    }
}
