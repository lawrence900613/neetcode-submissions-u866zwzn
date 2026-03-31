class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // row
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> seen = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j]) && seen.contains(board[i][j])) {
                    return false;
                } else {
                    seen.add(board[i][j]);
                }
            }
        }

        // Col
        for (int i = 0; i < board[0].length; i++) {
            HashSet<Character> seen = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (Character.isDigit(board[j][i]) && seen.contains(board[j][i])) {
                    return false;
                } else {
                    seen.add(board[j][i]);
                }
            }
        } 

        // Matrix

        for (int mat_i = 0; mat_i < 3; mat_i++) {
            for (int mat_j = 0; mat_j < 3; mat_j++) {
                
                HashSet<Character> seen = new HashSet<Character>();
                for (int i = 0; i < 3; i ++) {
                    int row = mat_i * 3 + i;
                    for (int j = 0; j < 3; j ++) {
                        int col = mat_j * 3 + j;
                        if (Character.isDigit(board[row][col]) && seen.contains(board[row][col])) {
                            return false;
                        } else {
                            seen.add(board[row][col]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
