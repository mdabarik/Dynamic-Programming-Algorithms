import java.util.*;
public class Main{
    public int dfs(List<Integer> sizes, int curLen, int index, int[][] dp) {
        if (curLen == 0) return 0;
        if (index < 0) return -1;
        if (dp[index][curLen] != -1) return dp[index][curLen];
        int take = -1;
        if (curLen >= sizes.get(index)) {
            take = dfs(sizes, curLen - sizes.get(index), index, dp);
            if (take != -1)
                take = 1 + take;
        }
        int notTake = dfs(sizes, curLen, index - 1, dp);
        return dp[index][curLen] = Math.max(take, notTake);
    }
    public int countRibbonPieces(int n, List<Integer> sizes)
    {
        int[][] dp = new int[sizes.size()][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(sizes, n, sizes.size() - 1, dp);
    }
}
