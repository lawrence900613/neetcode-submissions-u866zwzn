class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        int longestLength = 1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int x = i;
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }
                longestLength = Math.max(count, longestLength);
            }
        }

        return longestLength;
    }
}