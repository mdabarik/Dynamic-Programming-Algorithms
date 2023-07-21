// Practice URL: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

class Solution {
	public int minDifference(int arr[], int n) { 
	    if (n == 1) // [11] -> [11], []
	        return arr[0];
	    int sum = 0;
	    for (int num : arr) sum += num;
	    int[][] dp = new int[n][sum + 1];
	    for (int[] a : dp) Arrays.fill(a, -1);
	    return dfs(arr, 0, 0, 0, dp);
	} 
	// sub1: sum1, sub2: sum2, sum1 + sum2 = sum
	public int dfs(int[] arr, int sum1, int sum2, int index, int[][] dp) {
	    if (index == arr.length) {
	        return Math.abs(sum1 - sum2);
	    }
	    if (dp[index][sum1] != -1) return dp[index][sum1];
	    if (dp[index][sum2] != -1) return dp[index][sum2];
	    int left = dfs(arr, sum1 + arr[index], sum2, index + 1, dp);
	    int right = dfs(arr, sum1, sum2 + arr[index], index + 1, dp);
	    dp[index][sum1] = Math.min(left, right);
	    dp[index][sum2] = Math.min(left, right);
	    return Math.min(left, right);
	}
}
// TC: O(2^n) ~ O(n * sum), SC: O(n) ~ O(n * sum)