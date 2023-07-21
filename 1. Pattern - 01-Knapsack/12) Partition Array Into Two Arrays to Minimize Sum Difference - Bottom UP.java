// Practice URL: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

class Solution {
	public int minDifference(int arr[], int n) { 
	    if (n == 1) return arr[0]; // [11] -> [11], []
	    int sum = 0;
	    for (int num : arr) sum += num;
	    int target = sum / 2;
	    boolean[] dp = new boolean[target + 1];
	    dp[0] = true; // []
	    for (int i = 0; i < arr.length; i++) {
	        for (int curTarget = target; curTarget >= 1; curTarget--) {
	            if (curTarget >= arr[i]) {
	                dp[curTarget] = dp[curTarget] || dp[curTarget - arr[i]];
	            }
	        }
	    }
	    int subArraySum1 = 0;
	    for (int curTarget = 0; curTarget < dp.length; curTarget++) {
	        if (dp[curTarget] == true) subArraySum1 = curTarget;
	    }
	    int subArraySum2 = sum - subArraySum1;
	    return Math.abs(subArraySum1 - subArraySum2);
	} 
} // TC: O(n * target), SC: O(target) ~~~ target = sum/2