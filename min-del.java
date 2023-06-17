import java.util.*;

class MinDel {
    public static int dfs(int[] nums, int prev, int curr, int[][] dp) {
        // base case
        if (curr >= nums.length) return 0;
        if (dp[curr][prev + 1] != -1) return dp[curr][prev + 1];
        // recursive case
        int notTake = dfs(nums, prev, curr + 1, dp);
        int take = 0;
        if (prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + dfs(nums, curr, curr + 1, dp);
        }
        return dp[curr][prev + 1] = Math.max(take, notTake);
    }
    public static int minDeletions(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int lenOfLIS = dfs(nums, -1, 0, dp);
        return n - lenOfLIS;
    }
}
// TC: O(n^2), SC: O(n^2)
