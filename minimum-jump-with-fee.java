import java.util.*;
public class MinFee {

   public static int dfs(int[] fee, int n, int[] dp) {
      // base case
      if (n < 1) return 0;
      if (dp[n] != -1) return dp[n];
      // recursive case
      int oneStep = fee[n - 1] + dfs(fee, n - 1, dp);

      int twoStep = 0;
      if (n - 2 >= 0) {
         twoStep = fee[n - 2] + dfs(fee, n - 2, dp);
      } else {
         twoStep = fee[n - 2 + fee.length];
      }

      int thirdStep = 0;
      if (n - 3 >= 0) { 
         thirdStep = fee[n - 3] + dfs(fee, n - 3, dp);
      } else {
         thirdStep = fee[n - 3 + fee.length];
      }

      return dp[n] = Math.min(Math.min(oneStep, twoStep), thirdStep);


   }

   public static int minFee(int[] fee, int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, -1);
      return dfs(fee, n, dp);
   }
}
