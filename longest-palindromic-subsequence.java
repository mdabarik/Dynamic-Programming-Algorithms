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
