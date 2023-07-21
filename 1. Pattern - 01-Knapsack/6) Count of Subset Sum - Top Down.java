// Practice URL: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1

class Solution{
    int mod = 1000000007;
    public int dfs(int[] arr, int sum, int index, int[][] dp) {
        if (index == arr.length) {
            return sum == 0 ? 1 : 0;
        }
        if (dp[index][sum] != -1) return dp[index][sum];
        int take = 0;
        if (sum >= arr[index]) {
            take = dfs(arr, sum - arr[index], index + 1, dp);
        }
        int notTake = dfs(arr, sum, index + 1, dp);
        return dp[index][sum] = (take + notTake) % mod;
    }
	public int perfectSum(int arr[],int n, int sum) {
	    int[][] dp = new int[n][sum + 1];
	    for (int[] a : dp) Arrays.fill(a, -1);
	    return dfs(arr, sum, 0, dp);
	} 
} // TC: O(2 ^ n) ~ O(n * sum), SC: O(n + n * sum)