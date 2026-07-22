class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Queue<Character> queue = new LinkedList<>();
        while(r < s.length()) {
            while(queue.contains(s.charAt(r))) {
                queue.poll();
                l+= 1;
            }
            queue.offer(s.charAt(r));
            max = Math.max(max, r - l + 1);
            r+=1;
        }
        return max;
    }
}
