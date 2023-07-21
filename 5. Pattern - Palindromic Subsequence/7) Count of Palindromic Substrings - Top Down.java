class Solution {
    public boolean isPalindrome(String s, int i, int j) {
        // base case
        if (i > j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        // recursive case
        return isPalindrome(s, i + 1, j - 1);
    }
    public int dfs(String s, int i, int j, int[][] dp) {
        // base case
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        // recursive case
        int count = 0;
        if (s.charAt(i) == s.charAt(j) && isPalindrome(s, i, j)) {
            count = 1 + dfs(s, i + 1, j, dp) + dfs(s, i, j - 1, dp) - dfs(s, i + 1, j - 1, dp);
        } else {
            count = 0 + dfs(s, i + 1, j, dp) + dfs(s, i, j - 1, dp) - dfs(s, i + 1, j - 1, dp);
        }
        return dp[i][j] = count;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return n + dfs(s, 0, n - 1, dp);
    }
}

// TC: O(n^3), SC: O(n^2)