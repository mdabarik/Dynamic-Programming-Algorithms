import java.util.*;

class Main {
    public static int dfs(String s, int start, int end) {
        // base case
        if (start == end) return 1;
        // recursive case
        if (s.charAt(start) == s.charAt(end)) {
            if (end - start + 1 == 2) return 2;
            if (end - start + 1 == 2 + dfs(s, start + 1, end - 1)) return end - start + 1;
        }
        int left = dfs(s, start + 1, end);
        int right = dfs(s, start, end - 1);
        return Math.max(left, right);
    }
    public static int findLpsLength(String s){ 
        int n = s.length();
        return dfs(s, 0, n - 1);
    }
}


class Main {
    public static int dfs(String s, int start, int end) {
        // base case
        if (start == end) return 1;
        // recursive case
        if (s.charAt(start) == s.charAt(end)) {
            if (end - start + 1 == 2) return 2;
            if (end - start + 1 == 2 + dfs(s, start + 1, end - 1)) return end - start + 1;
        }
        int left = dfs(s, start + 1, end);
        int right = dfs(s, start, end - 1);
        return Math.max(left, right);
    }
    public static int findLpsLength(String s){ 
        int n = s.length();
        return dfs(s, 0, n - 1);
    }
}


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
                    if (end - start + 1 == 2) {
                        max = 2;
                    } else if (end - start + 1 == 2 + dp[start + 1][end - 1]) {
                        max = end - start + 1; 
                    }
                }
                int left = dp[start + 1][end];
                int right = dp[start][end - 1];
                dp[start][end] = Math.max(max, Math.max(left, right));
            }
        }
        return dp[0][n - 1];
    }
}

