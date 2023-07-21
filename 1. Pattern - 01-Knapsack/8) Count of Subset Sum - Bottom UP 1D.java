/* Practice URL: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1 */

class Solution {
    int mod = (int)1e9 + 7;
	public int perfectSum(int arr[],int n, int sum) { 
	    int[] dp = new int[sum + 1];
	    dp[0] = 1;
	    for (int i = 0; i < n; i++) {
	        for (int s = sum; s >= 0; s--) {
	            if (s >= arr[i]) {
	                dp[s] = (dp[s] + dp[s - arr[i]]) % mod;
	            }
	        }
	    }
	    return dp[sum];
	} 
} // TC: O(n * sum), SC: O(sum)