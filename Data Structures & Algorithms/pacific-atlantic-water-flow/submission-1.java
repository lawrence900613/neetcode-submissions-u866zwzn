class Solution {
    int rows, cols;
    int[][] h;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ret = new ArrayList<>();
        h = heights;
        rows = h.length;
        cols = h[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visP = new boolean[rows][cols];
                boolean[][] visA = new boolean[rows][cols];

                if (explorePacific(i, j, visP) && exploreAtlantic(i, j, visA)) {
                    ret.add(List.of(i, j));
                }
            }
        }
        return ret;
    }

    // Can reach top or left border
    private boolean explorePacific(int i, int j, boolean[][] vis) {
        if (i == 0 || j == 0) return true;
        if (vis[i][j]) return false;
        vis[i][j] = true;

        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni < 0 || nj < 0 || ni >= rows || nj >= cols) continue;

            // flow downhill or flat
            if (h[i][j] >= h[ni][nj]) {
                if (explorePacific(ni, nj, vis)) return true;
            }
        }
        return false;
    }

    // Can reach bottom or right border
    private boolean exploreAtlantic(int i, int j, boolean[][] vis) {
        if (i == rows - 1 || j == cols - 1) return true;
        if (vis[i][j]) return false;
        vis[i][j] = true;

        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni < 0 || nj < 0 || ni >= rows || nj >= cols) continue;

            if (h[i][j] >= h[ni][nj]) {
                if (exploreAtlantic(ni, nj, vis)) return true;
            }
        }
        return false;
    }
}

