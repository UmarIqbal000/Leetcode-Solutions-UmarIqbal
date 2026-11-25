class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            int rowMax = 0;
            int colMax = 0;

            for (int j = 0; j < n; j++) {
                // Top projection: non-zero tower adds 1 to the xy shadow
                if (grid[i][j] > 0) {
                    totalArea++;
                }

                // Max height in row i (one side projection)
                if (grid[i][j] > rowMax) {
                    rowMax = grid[i][j];
                }

                // Max height in column i (other side projection)
                if (grid[j][i] > colMax) {
                    colMax = grid[j][i];
                }
            }

            totalArea += rowMax + colMax;
        }

        return totalArea;
    }
}