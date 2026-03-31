class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] used = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    explore(grid, used, i, j);
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public void explore(char[][] grid, boolean[][] used, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || used[i][j]) {
            return;
        }

        used[i][j] = true;
        explore(grid, used, i + 1, j);
        explore(grid, used, i - 1, j);
        explore(grid, used, i, j + 1);
        explore(grid, used, i, j - 1);
    }
}
