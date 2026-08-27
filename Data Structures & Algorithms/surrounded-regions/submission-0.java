class Solution {
    private int ROWS, COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            if (board[row][0] == 'O') {
                capture(board, row, 0);
            }
            if (board[row][COLS - 1] == 'O') {
                capture(board, row, COLS - 1);
            }
        }

        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == 'O') {
                capture(board, 0, col);
            }
            if (board[ROWS - 1][col] == 'O') {
                capture(board, ROWS - 1, col);
            }
        }
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= ROWS || col >= COLS || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        capture(board, row + 1, col);
        capture(board, row - 1, col);
        capture(board, row, col + 1);
        capture(board, row, col - 1);
    }
}
