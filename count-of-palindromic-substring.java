import java.util.*;

public class Main{
    public static boolean isPalindrome(String s, int i, int j) {
        if (i > j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalindrome(s, i + 1, j - 1);
    }
    public static int dfs(String s, int i, int j) {
        if (i >= j) return 0;
        int count = 0;
        if (isPalindrome(s, i, j)) {
            count = 1 + dfs(s, i + 1, j) + dfs(s, i, j - 1) - dfs(s, i + 1, j - 1);
        } else {
            count = dfs(s, i + 1, j) + dfs(s, i, j - 1) - dfs(s, i + 1, j - 1);
        }
        return count;
    }
    public static Integer countPalindromicSubstring (String str1) {
        return str1.length() + dfs(str1, 0, str1.length() - 1);
    }
}

// TC: O(3^n), SC: O(n)



import java.util.*;

public class Main{
    public static boolean isPalindrome(String s, int i, int j) {
        if (i > j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalindrome(s, i + 1, j - 1);
    }
    public static int dfs(String s, int i, int j, int[][] dp) {
        // bae case
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        // recursive case
        int count = 0;
        if (isPalindrome(s, i, j)) {
            count = 1 + dfs(s, i + 1, j, dp) + dfs(s, i, j - 1, dp) - dfs(s, i + 1, j - 1, dp);
        } else {
            count = dfs(s, i + 1, j, dp) + dfs(s, i, j - 1, dp) - dfs(s, i + 1, j - 1, dp);
        }
        return dp[i][j] = count;
    }
    public static Integer countPalindromicSubstring (String str1) {
        int n = str1.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return str1.length() + dfs(str1, 0, n - 1, dp);
    }
}
// TC: O(n^2), SC: O(n^2)


import java.util.*;

public class Main{
    public static Integer countPalindromicSubstring (String str1) {
        int n = str1.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (str1.charAt(i) == str1.charAt(j)) {
                    if (i+1 >= j)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                
                if (dp[i][j] == true) 
                count++;
            }
        }
        return str1.length() + count;
    }
}

// TC: O(n^2), SC: O(n^2)
