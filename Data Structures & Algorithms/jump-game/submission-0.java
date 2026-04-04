class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return dfs(nums, 0);
    }

    boolean dfs(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }
        if(dp[i] != null) {
            return dp[i];
        } 

        int max = nums[i];
        for(int j = 1; j <= max; j++) {
            if(dfs(nums, i+j)) {
                dp[i] = true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }

}
