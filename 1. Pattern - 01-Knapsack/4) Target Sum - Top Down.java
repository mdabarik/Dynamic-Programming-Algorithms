class Solution {
    public int dfs(int[] nums, int target, int index, int sum, int[][] dp, int total) {
        if (index == nums.length)
            return target == sum ? 1 : 0;
        if (dp[index][sum + total] != -1) return dp[index][sum + total];
        int add = dfs(nums, target, index + 1, sum + nums[index], dp, total);
        int sub = dfs(nums, target, index + 1, sum - nums[index], dp, total);
        return dp[index][sum + total] = add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (Math.abs(target) > total) return 0;
        
        int[][] dp = new int[nums.length][total * 2 + 1]; // -total, +total
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return dfs(nums, target, 0, 0, dp, total);
    }
}
// TC: O(n * total), SC: O(n * total)