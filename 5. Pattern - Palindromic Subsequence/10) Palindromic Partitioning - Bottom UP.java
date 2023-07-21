

//User function Template for Java

class Solution {
    static void constructPalTable(String s, boolean[][] palTable) {
        int n = s.length();
        for (int i = 0; i < n; i++) 
            palTable[i][i] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) // if the length of i->j window is 2
                        palTable[i][j] = true;
                    else if (palTable[i + 1][j - 1]) // s[i+1 -> j-1]
                        palTable[i][j] = true;
                }
            }
        }
    }
    static int palindromicPartition(String str) {
        int n = str.length();
        boolean[][] palTable = new boolean[n][n];
        constructPalTable(str, palTable);
        
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = n - 1; i >= 0; i--) {
            if (palTable[i][n - 1] == true)
                dp[i] = 0;
            else {
                for (int j = n - 2; j >= i; j--) {
                    if (palTable[i][j] == true)
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}// TC: O(n^2), SC: O(n^2)