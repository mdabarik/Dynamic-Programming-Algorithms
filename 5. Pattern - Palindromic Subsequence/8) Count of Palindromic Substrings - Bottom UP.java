class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int count = n;
        for (int i = n - 2; i >= 0; i--) { // i == start
            for (int j = i + 1; j < n; j++) { // j == end
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) { // if the length form i to j is 2
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}

// TC: O(n^2), SC: O(n^2)