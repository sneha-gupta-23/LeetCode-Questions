class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int oldColor = image[sr][sc];

        if (oldColor == color)
            return image;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];

            // UP
            if (i - 1 >= 0 && image[i - 1][j] == oldColor) {
                image[i - 1][j] = color;
                q.offer(new int[]{i - 1, j});
            }

            // DOWN
            if (i + 1 < n && image[i + 1][j] == oldColor) {
                image[i + 1][j] = color;
                q.offer(new int[]{i + 1, j});
            }

            // LEFT
            if (j - 1 >= 0 && image[i][j - 1] == oldColor) {
                image[i][j - 1] = color;
                q.offer(new int[]{i, j - 1});
            }

            // RIGHT
            if (j + 1 < m && image[i][j + 1] == oldColor) {
                image[i][j + 1] = color;
                q.offer(new int[]{i, j + 1});
            }
        }

        return image;
    }
}