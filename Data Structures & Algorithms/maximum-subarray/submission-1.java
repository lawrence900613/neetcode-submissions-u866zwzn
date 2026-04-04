class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = current;
        for (int j = 1; j < nums.length; j++) {
            // Smaller Case
            if((nums[j] + current) < nums[j]) {
                current = nums[j];
                max = Math.max(current, max);
            } else {
                current = nums[j] + current;
                max = Math.max(current, max);
            }
        }
        return max;
    }
}
