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
