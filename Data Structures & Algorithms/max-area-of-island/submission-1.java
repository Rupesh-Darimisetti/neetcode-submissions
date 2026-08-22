class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 1) {
                    area = Math.max(area, dfs(grid, row, col));
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
            || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int result = 1;
        for (int[] dir : directions) {
            result += dfs(grid, row + dir[0], col + dir[1]);
        }
        return result;
    }
}
