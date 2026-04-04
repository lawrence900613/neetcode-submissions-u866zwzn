class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(word1, word2, 0, 0);
    }
    
    int dfs(String word1, String word2, int i, int j) {
        if(i == word1.length() && j == word2.length()) {
            return 0;
        }

        if(i == word1.length()) {
            return (word2.length() - j); 
        }

        if(j == word2.length()) {
            return (word1.length() - i);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
 
        if(word1.charAt(i) == word2.charAt(j)) {
            return dfs(word1, word2, i + 1, j + 1);
        }
        int ret = Integer.MAX_VALUE;
        // Insert
        ret = Math.min(ret, 1 + dfs(word1, word2, i, j + 1));
        // Delete
        ret = Math.min(ret, 1 + dfs(word1, word2, i + 1, j));
        // Replace
        ret = Math.min(ret, 1 + dfs(word1, word2, i + 1, j + 1));
        dp[i][j] = ret;
        return ret;
    }
}
