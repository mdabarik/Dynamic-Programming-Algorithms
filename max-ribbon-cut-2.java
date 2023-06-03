import java.util.*;
public class Main{
    public int dfs(List<Integer> sizes, int ribLen, int index, int[][] dp) {
        // base case
        if (ribLen == 0) return 0;
        if (index < 0) return -1;
        if (dp[index][ribLen] != -1) return dp[index][ribLen];
        // recursive
        int take = -1;
        if (ribLen >= sizes.get(index)) {
            take = dfs(sizes, ribLen - sizes.get(index), index, dp);
            if (take != -1)
                take = 1 + take;
        }
        int notTake = dfs(sizes, ribLen, index - 1, dp);
        return dp[index][ribLen] = Math.max(take, notTake);
    }
    public int countRibbonPieces(int n, List<Integer> sizes)
    {
        int[][] dp = new int[sizes.size()][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(sizes, n, sizes.size() - 1, dp);
    }
}

// TC: O(N * L), SC: O(N * L)F
