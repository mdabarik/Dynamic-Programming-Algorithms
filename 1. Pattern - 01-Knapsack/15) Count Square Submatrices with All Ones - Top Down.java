// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row : dp) Arrays.fill(row, -1);
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && dp[i][j] == -1) {
                    count += countSquareMatrix(matrix, i, j, dp);
                } else if (dp[i][j] != -1) {
                    count += dp[i][j];
                }
            }
        }
        return count;
    }

    public int countSquareMatrix(int[][] matrix, int r, int c, int[][] dp) {
        if (r >= matrix.length || c >= matrix[0].length || matrix[r][c] == 0)
            return 0;
        if (dp[r][c] != -1) return dp[r][c];
        int right = countSquareMatrix(matrix, r, c + 1, dp);
        int bottom = countSquareMatrix(matrix, r + 1, c, dp);
        int bottomRight = countSquareMatrix(matrix, r + 1, c + 1, dp);
        return dp[r][c] = 1 + Math.min(right, Math.min(bottom, bottomRight));
    }
}

// TC: O(M * 3^M) ~ O(M), SC: O(M) ~ O(M)