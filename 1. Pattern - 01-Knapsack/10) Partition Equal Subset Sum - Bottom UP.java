/* URL: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1 */

class Solution{
    static int equalPartition(int N, int arr[]) {
        int total = Arrays.stream(arr).sum();
        if (total % 2 == 1) return 0;
        
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int i = 0; i < arr.length; i++) {
            for (int curr = dp.length - 1; curr >= 1; curr--) {
                if (curr >= arr[i]) {
                    dp[curr] = dp[curr] || dp[curr - arr[i]];
                }
            }
        }
        return dp[target] == true ? 1 : 0;
    }
} // TC: O(n * target), SC: O(target)