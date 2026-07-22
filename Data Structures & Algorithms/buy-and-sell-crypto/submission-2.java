class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        return dfs(prices, false, 0, 0, ret);
    }

    public int dfs(int[] prices, boolean hold, int boughtDay, int day, int max) 
    {
        if(day >= prices.length) {
            return max;
        }
        if(hold) {
            int sellPrice = prices[day] - prices[boughtDay];
            return Math.max(Math.max(sellPrice, max), dfs(prices, hold, boughtDay, day + 1, max));
        } else {
            return Math.max(dfs(prices, false, 0, day + 1, max), dfs(prices, true, day, day + 1, max)); 
        }
    }
}
