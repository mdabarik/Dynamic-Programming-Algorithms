import java.util.*;

class BuildingBridges{
   public static int maxBridgesCount(int[] north, int[] south) {
      List<List<Integer>> pairs = new ArrayList<>();
      for (int i = 0; i < north.length; i++)
         pairs.add(new ArrayList<>(Arrays.asList(north[i], south[i])));
      Collections.sort(pairs, (a, b) -> a.get(1) - b.get(1));

      int[] newNorth = new int[north.length];
      for (int i = 0; i < north.length; i++) {
         newNorth[i] = pairs.get(i).get(0);
      }

      System.out.print(Arrays.toString(newNorth));

      int lis = 0;
      int[] dp = new int[north.length];
      dp[0] = 1;
      for (int i = 1; i < north.length; i++) {
         int curr = 0;
         for (int j = 0; j < i; j++) {
            if (newNorth[j] < newNorth[i]) {
               curr = Math.max(curr, dp[j]);
            }
         }
         dp[i] = 1 + curr;
         lis = Math.max(dp[i], lis);
      }
      return lis;

   }
}
