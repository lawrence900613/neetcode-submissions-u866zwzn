class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int k) {
        // bounds
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (used[i][j]) return false;

        // mismatch
        if (board[i][j] != word.charAt(k)) return false;

        // matched all chars
        if (k == word.length() - 1) return true;

        used[i][j] = true;

        boolean found =
            dfs(board, word, used, i + 1, j, k + 1) ||
            dfs(board, word, used, i - 1, j, k + 1) ||
            dfs(board, word, used, i, j + 1, k + 1) ||
            dfs(board, word, used, i, j - 1, k + 1);

        used[i][j] = false;
        return found;
    }
}
