// https://leetcode.com/problems/minimum-number-of-refueling-stops/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int[] maxDistance = new int[n + 1]; // index = number of refueling stations
        // n stations: 0 -> n
        for (int i = 0; i <= n; i++) {
            maxDistance[i] = dfs(stations, startFuel, n, i, dp);
        }
        for (int i = 0; i < maxDistance.length; i++) {
            if (maxDistance[i] >= target) 
                return i;
        }
        return -1;
    }
    public int dfs(int[][] stations, int startFuel, int currStation, int numRefuel, int[][] dp) {
        // base case
        if (numRefuel == 0) return startFuel;
        if (numRefuel > currStation) return Integer.MIN_VALUE;
        if (dp[currStation][numRefuel] != -1) return dp[currStation][numRefuel];
        // recursive case
        int notRefuel = dfs(stations, startFuel, currStation - 1, numRefuel, dp);
        int refuel = dfs(stations, startFuel, currStation - 1, numRefuel - 1, dp);
        if (stations[currStation - 1][0] <= refuel) {
            refuel += stations[currStation - 1][1];
        } else {
            refuel = Integer.MIN_VALUE;
        }
        return dp[currStation][numRefuel] = Math.max(refuel, notRefuel);
    }
} // TC: O(n * 2^n) ~ O(n^2), SC: O(n) ~ O(n^2)