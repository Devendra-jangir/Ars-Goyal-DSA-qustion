class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--)
            piles[i] += piles[i+1];
        dp = new int[n][n];
        return solve(1, 0, piles);
    }
    private int[][] dp;
    private int solve(int m, int index, int[] piles){
        if (index == piles.length) return 0;
        else if (index + 2 * m >= piles.length) return piles[index];
        else if (dp[m][index] != 0) return dp[m][index];
        int res = 0, take = 0;
        for (int x = 1; x <= 2 * m && x + index < piles.length; x++){
            take = piles[index] - piles[index + x];
            res = Math.max(res, take + piles[index + x] - solve(Math.max(m, x), index + x, piles));
        }
        return dp[m][index] = res;
    }
}