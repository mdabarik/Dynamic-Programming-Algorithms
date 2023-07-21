// https://leetcode.com/problems/minimum-number-of-refueling-stops/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = startFuel;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = startFuel;
        }
        for (int currStation = 1; currStation <= n; currStation++) { // i == currStation
            for (int numRefuel = 1; numRefuel <= currStation; numRefuel++) { // j == numReful
                int refuel = 0;
                if (stations[currStation - 1][0] <= dp[currStation - 1][numRefuel - 1]) {
                    refuel = stations[currStation - 1][1] + dp[currStation - 1][numRefuel - 1];
                }
                int notRefuel = dp[currStation - 1][numRefuel];
                dp[currStation][numRefuel] = Math.max(refuel, notRefuel);
            }
        }
        for (int numRefuel = 0; numRefuel <= n; numRefuel++) {
            if (dp[n][numRefuel] >= target) return numRefuel;
        }
        return -1;
    }
} // TC: O(n^2), SC: O(n^2)