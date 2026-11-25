import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] minRow = new int[m];
        Arrays.fill(minRow, Integer.MAX_VALUE);

        int[] maxCol = new int[n];
        Arrays.fill(maxCol, Integer.MIN_VALUE);

        // Compute minimum of each row and maximum of each column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val < minRow[i]) {
                    minRow[i] = val;
                }
                if (val > maxCol[j]) {
                    maxCol[j] = val;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        // Collect elements that are both row-minimum and column-maximum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val == minRow[i] && val == maxCol[j]) {
                    result.add(val);
                }
            }
        }

        return result;
    }
}