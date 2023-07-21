class Solution {
    static int knapSack(int W, int wt[], int val[], int n) { 
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int take = 0;
                if (j >= wt[i - 1])
                    take = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                int notTake = dp[i - 1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n][W];
    } 
}
// TC: O(n * W), SC: O(n * W)