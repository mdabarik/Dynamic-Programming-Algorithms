public class Main {
    public static int dfs(String s1, String s2, int i, int j) {
        if (i >= s1.length()) return s2.length() - j;
        if (j >= s2.length()) return s1.length() - i;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + dfs(s1, s2, i + 1, j + 1);
        }
        int len1 = 1 + dfs(s1, s2, i + 1, j);
        int len2 = 1 + dfs(s1, s2, i, j + 1);
        return Math.min(len1, len2);
    }
    public static int shortestCommonSupersequence(String str1, String str2) {
        return dfs(str1, str2, 0, 0);
    }
};

import java.util.*;

public class Main {
    public static int dfs(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length()) return s2.length() - j;
        if (j >= s2.length()) return s1.length() - i;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + dfs(s1, s2, i + 1, j + 1, dp);
        }
        int len1 = 1 + dfs(s1, s2, i + 1, j, dp);
        int len2 = 1 + dfs(s1, s2, i, j + 1, dp);
        return dp[i][j] = Math.min(len1, len2);
    }
    public static int shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(str1, str2, 0, 0, dp);
    }
};


public class Main {
    public static int shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++) 
            dp[0][i] = i;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
