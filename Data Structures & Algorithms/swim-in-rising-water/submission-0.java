class Solution {
    public int swimInWater(int[][] grid) {
        int gridLength = grid.length;
        boolean[][] visit = new boolean[gridLength][gridLength];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        minHeap.offer(new int[] {grid[0][0], 0, 0});
        visit[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int timeSoFar = current[0], row = current[1], column = current[2];
            if (row == gridLength - 1 && gridLength - 1 == column) {
                return timeSoFar;
            }
            for (int[] direction : directions) {
                int neighbourRow = row + direction[0], neighbourColumn = column + direction[1];
                if (neighbourRow >= 0 && neighbourColumn >= 0 && neighbourRow < gridLength
                    && neighbourColumn < gridLength && !visit[neighbourRow][neighbourColumn]) {
                    visit[neighbourRow][neighbourColumn] = true;
                    minHeap.offer(
                        new int[] {Math.max(timeSoFar, grid[neighbourRow][neighbourColumn]),
                            neighbourRow, neighbourColumn});
                }
            }
        }
        return gridLength * gridLength;
    }
}
