class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0);
    }

    int dfs(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if(dp[i] != -1) {
            return (int)dp[i];
        } 

        int min = 10000;
        for(int j = 1; j <= nums[i]; j++) {
            min = Math.min(min, 1 + dfs(nums, i + j));
        }
        dp[i] = min;
        return min;
    }
}
