import java.util.*;

class LIS {
    public static int lisLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int length = dp[curr + 1][prev + 1];
                if (prev < 0 || nums[prev] < nums[curr]) {
                    length = Math.max(length, 1 + dp[curr + 1][curr + 1]);
                }
                dp[curr][prev + 1] = length;
            }
        }
        return dp[0][0]
    }
}
