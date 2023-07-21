/* Practice URL: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1 */

class Solution{
	public int perfectSum(int arr[],int n, int sum) {
	    int[][] dp = new int[n][sum + 1]; // 0 ~ sum
	    
	    // case 1, case2
	    if (arr[0] == 0) { // base case 1
	        dp[0][0] = 2; // [], [0]
	    } else { // base case 2
	        dp[0][0] = 1; // []
	        if (arr[0] <= sum) {
	            dp[0][arr[0]] = 1; // [arr[0]]
	        }
	    }
	    
	    for (int row = 1; row < dp.length; row++) {
	        for (int curSum = 0; curSum < dp[0].length; curSum++) {
	            int include = 0; // int take = 0;
	            if (arr[row] <= curSum) {
	                include = dp[row - 1][curSum - arr[row]];
	            }
	            int exclude = dp[row - 1][curSum];
	            dp[row][curSum] = (include + exclude) % 1000000007; // 10^9 + 7
	        }
	    }
	    
	    return dp[n - 1][sum];
	} 
}  // TC: O(n * sum), SC: O(n * sum)