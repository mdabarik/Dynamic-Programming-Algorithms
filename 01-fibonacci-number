// 1# Bottom Up Solution
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
} // TC: O(n), SC: O(n)

// 2# Top Down Memoization
class Solution {
    int dfs(int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        int left = dfs(n-1, dp); // step1
        int right = dfs(n-2, dp); // step2
        dp[n] = left + right;
        return dp[n];
    }
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return dfs(n, dp);
    }
} // TC: O(n), SC: O(n)

// 3# Bottom Up Space Optimized
class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int first = 0, second = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
} // TC: O(n), SC: O(1)
