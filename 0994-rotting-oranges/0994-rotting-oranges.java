class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            while (size-- > 0) {

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                // UP
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    fresh--;
                    queue.offer(new int[]{r - 1, c});
                }

                // DOWN
                if (r + 1 < rows && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    fresh--;
                    queue.offer(new int[]{r + 1, c});
                }

                // LEFT
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{r, c - 1});
                }

                // RIGHT
                if (c + 1 < cols && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{r, c + 1});
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}