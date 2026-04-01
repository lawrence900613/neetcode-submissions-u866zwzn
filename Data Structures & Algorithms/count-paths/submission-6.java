class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dfs(0, 0, m - 1, n - 1, dp);
        return dfs(0, 0, m - 1, n - 1, dp);
    }

    int dfs(int row, int col, int m, int n, int[][] dp) {
        if (row == m && col == n) {
            return 1;
        }
        if (row > m || col > n) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        dp[row][col] = dfs(row, col + 1, m, n, dp) + dfs(row + 1, col, m , n, dp);
        return dp[row][col];
    }
}
