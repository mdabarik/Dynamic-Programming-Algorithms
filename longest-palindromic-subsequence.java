public class Main {
    public static int dfs(String s, int start, int end) {
        // base case
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        // recursive case
        if (s.charAt(start) == s.charAt(end))
            return 2 + dfs(s, start + 1, end - 1);
        int c1 = dfs(s, start + 1, end);
        int c2 = dfs(s, start, end - 1);
        return Math.max(c1, c2);
    }

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        return dfs(s, 0, n - 1);
    }
}


import java.util.*;

public class Main {

    public static int dfs(String s, int start, int end, int[][] dp) {
        // base case
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (dp[start][end] != -1) return dp[start][end];
        // recursive case
        if (s.charAt(start) == s.charAt(end))
            return 2 + dfs(s, start + 1, end - 1, dp);
        int c1 = dfs(s, start + 1, end, dp);
        int c2 = dfs(s, start, end - 1, dp);
        return dp[start][end] = Math.max(c1, c2);
    }

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(s, 0, n - 1, dp);
    }

}
