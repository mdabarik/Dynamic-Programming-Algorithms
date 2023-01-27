/* Problem Statement:
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    
Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3 
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3. */


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
