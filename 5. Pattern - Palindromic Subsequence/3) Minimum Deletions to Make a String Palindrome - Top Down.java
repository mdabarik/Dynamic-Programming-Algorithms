
class Solution {
    int dfs(String s, int start, int end, int[][] dp) {
        // base case
        if (start == end) return 1;
        if (start > end) return 0;
        if (dp[start][end] != -1) return dp[start][end];
        // recursive case
        if (s.charAt(start) == s.charAt(end)) {
            return 2 + dfs(s, start + 1, end - 1, dp);
        }
        int left = dfs(s, start + 1, end, dp);
        int right = dfs(s, start, end - 1, dp);
        return dp[start][end] = Math.max(left, right);
    }
    int minDeletions(String str, int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int lenOfLPS = dfs(str, 0, n - 1, dp);
        return n - lenOfLPS;
    }
}

// TC: O(n^2), SC: O(n^2)