class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        backtrack(0, board, res);
        return res;
    }

    private void backtrack(int row, char[][] board, List<List<String>> res) {
        if (row == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] rows : board) {
                copy.add(new String(rows));
            }
            res.add(copy);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int rows, int cols, char[][] board) {
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][cols] == 'Q') {
                return false;
            }
        }
        for (int row = rows - 1, col = cols - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q') {
                return false;
            }
        }
        for (int row = rows - 1, col = cols + 1; row >= 0 && col < board.length; row--, col++) {
            if (board[row][col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
