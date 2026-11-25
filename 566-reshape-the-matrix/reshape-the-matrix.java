class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        // If the total number of elements does not match, reshape is impossible
        if (m * n != r * c) {
            return mat;
        }
        
        int[][] res = new int[r][c];
        
        // Map 1D index to both the original (m x n) and new (r x c) matrices
        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        
        return res;
    }
}