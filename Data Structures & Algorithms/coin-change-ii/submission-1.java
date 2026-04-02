class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        return dfs(coins, 0, dp, amount);
    }

    int dfs(int[] coins, int i, int[][] dp,  int amount) {
        if (amount == 0) {
            return 1;
        } 
        if (i >= coins.length) {
            return 0;
        }
        if (dp[i][amount] != 0) return dp[i][amount];

        int ret = 0;
        if (amount >= coins[i]) {
            ret = dfs(coins, i + 1, dp, amount);
            ret += dfs(coins, i, dp, amount - coins[i]);
        }
        dp[i][amount] = ret;
        return ret;
    }
}
