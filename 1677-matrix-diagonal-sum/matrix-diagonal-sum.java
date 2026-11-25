class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Primary diagonal: mat[i][i]
            sum += mat[i][i];
            
            // Secondary diagonal: mat[i][n - 1 - i]
            sum += mat[i][n - 1 - i];
        }

        // If the dimension is odd, subtract the duplicate center element
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
}