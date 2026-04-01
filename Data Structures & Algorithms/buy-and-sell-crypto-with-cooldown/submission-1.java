class Solution {
    int[][] memo;

    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        return dfs(prices, 0, 1); 
    }

    int dfs(int[] prices, int i, int buy) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][buy] != 0) {
            return memo[i][buy];
        }

        int skip = dfs(prices, i + 1, buy);
        int ans;

        if (buy == 1) {
            int buying = dfs(prices, i + 1, 0) - prices[i];
            ans = Math.max(buying, skip);
        } else {
            int selling = dfs(prices, i + 2, 1) + prices[i]; 
            ans = Math.max(selling, skip);
        }

        memo[i][buy] = ans;
        return ans;
    }
}