class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (Math.abs(target) > total) return 0;
        
        int[][] dp = new int[nums.length][total * 2 + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) { // sum ~ current target
                if (dp[i - 1][sum + total] > 0) {
                    int add = nums[i] + sum; // positive sign
                    int sub = -nums[i] + sum; // negative sign
                    dp[i][add + total] += dp[i - 1][sum + total];
                    dp[i][sub + total] += dp[i - 1][sum + total];
                }
            }
        }
        
        return dp[nums.length - 1][target + total];
    }
} // TC: O(n * total), SC: O(n * total)