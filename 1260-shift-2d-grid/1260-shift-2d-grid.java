import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        int shift = k % total;

        List<List<Integer>> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>(n));
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int outIdx = r * n + c;
                int srcIdx = (outIdx - shift + total) % total;
                int srcRow = srcIdx / n;
                int srcCol = srcIdx % n;
                result.get(r).add(grid[srcRow][srcCol]);
            }
        }

        return result;
    }
}