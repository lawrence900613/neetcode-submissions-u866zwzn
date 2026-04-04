class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s, t, 0, 0);
    }

    int dfs(String s, String t, int i, int j) {
        if (j >= t.length()) {
            return 1;
        }

        if (i >= s.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ret = dfs(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            ret += dfs(s, t, i + 1, j + 1);
        }
        dp[i][j] = ret;
        return ret;

    }
}
