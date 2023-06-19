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
