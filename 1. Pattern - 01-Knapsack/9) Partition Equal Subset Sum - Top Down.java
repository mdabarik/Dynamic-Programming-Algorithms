/* URL: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1 */


class Solution {
    static boolean dfs(int[] arr, int target, int index, Boolean[] dp) {
        if (target == 0) return true;
        if (target < 0 || index >= arr.length) return false;
        if (dp[target] != null) return dp[target];
        boolean take = dfs(arr, target - arr[index], index + 1, dp);
        boolean notTake = dfs(arr, target, index + 1, dp);
        return dp[target] = take || notTake;
    }
    static int equalPartition(int N, int arr[]) {
        int total = Arrays.stream(arr).sum();
        if (total % 2 == 1) return 0;
        int target = total / 2;
        Boolean[] dp = new Boolean[target + 1];
        return dfs(arr, target, 0, dp) == true ? 1 : 0;
    }
} // TC: O(n * target), SC: O(target)