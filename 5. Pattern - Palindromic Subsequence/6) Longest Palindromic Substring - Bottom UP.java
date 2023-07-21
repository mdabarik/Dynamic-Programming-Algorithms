import java.util.*;

class Main {
    public static int findLpsLength(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int start = n - 2; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                int max = 0;
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start + 1 == 2) { // if the size of window is two
                        max = 2;
                    } else if (end - start + 1 == 2 + dp[start + 1][end - 1]) { // if the size of window greater than 2
                        max = end - start + 1;
                    } else { // if current window is not forming a valid palindrome
                        max = Math.max(max, Math.max(dp[start + 1][end], dp[start][end - 1]));
                    }
                } else { // if character at start and end pointer are not the same
                    max = Math.max(max, Math.max(dp[start + 1][end], dp[start][end - 1]));
                }
                dp[start][end] = max;
            }
        }
        return dp[0][n - 1];
    }
}
// TC: O(n^2), SC: O(n^2)
