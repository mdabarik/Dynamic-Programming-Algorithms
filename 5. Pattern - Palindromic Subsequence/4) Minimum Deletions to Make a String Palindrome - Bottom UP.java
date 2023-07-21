
class Solution  { 
    int minDeletions(String str, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int start = n - 2; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    int bottom = dp[start + 1][end];
                    int left = dp[start][end - 1];
                    dp[start][end] = Math.max(bottom, left);
                }
            }
        }
        return n - dp[0][n - 1];
    }
} 
// TC: O(n^2), SC: O(n^2)

