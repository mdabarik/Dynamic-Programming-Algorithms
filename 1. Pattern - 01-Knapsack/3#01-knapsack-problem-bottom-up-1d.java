class Solution {
    static int knapSack(int W, int wt[], int val[], int n) { 
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int w = W; w >= 0; w--) {
                if (w >= wt[i]) {
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
                }
            }
        }
        return dp[W];
    } 
}
// TC: O(n * W), SC: O(W)