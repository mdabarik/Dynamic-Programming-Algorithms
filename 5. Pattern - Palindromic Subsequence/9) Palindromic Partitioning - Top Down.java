

//User function Template for Java

class Solution {
    static boolean isPalindrome(String s, int i, int j) {
        // base case
        if (i > j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        // recursive case
        return isPalindrome(s, i + 1, j - 1);
    }
    static int dfs(String s, int i, int j, int[][] dp) {
        // base case
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(s, i, j)) return 0;
        // recursive case
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int totalCuts = 1 + dfs(s, i, k, dp) + dfs(s, k + 1, j, dp);
            min = Math.min(min, totalCuts);
        }
        return dp[i][j] = min;
    }
    static int palindromicPartition(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(str, 0, n - 1, dp);
    }
} // TC: o(n^3), SC: O(n^2)