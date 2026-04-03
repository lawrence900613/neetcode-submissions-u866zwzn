class Solution {
    int[][] dp;
    int max;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(i, j, matrix), max);
            }
        }
        return max;
    }

    int dfs(int i, int j, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ret = 1;
        if (i < (m - 1)) {
            if (matrix[i][j] < matrix[i + 1][j]) {
                ret = Math.max(ret, dfs(i + 1, j, matrix) + 1) ;
            } 
        }

        if (0 < i) {
            if (matrix[i][j] < matrix[i - 1][j]) {
                ret = Math.max(ret, dfs(i -1, j, matrix) + 1);
            } 
        }

        if (j < (n - 1)) {
            if (matrix[i][j] < matrix[i][j + 1]) {
                ret = Math.max(ret, dfs(i, j + 1, matrix) + 1);
            } 
        }

        if (0 < j) {
            if (matrix[i][j] < matrix[i][j - 1]) {
                ret = Math.max(ret, dfs(i, j - 1, matrix) + 1);
            } 
        }
        dp[i][j] = ret;
        return ret;
    }
}
