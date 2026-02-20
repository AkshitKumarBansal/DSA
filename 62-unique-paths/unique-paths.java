class Solution {
    public Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return solve(0, 0, m, n);
    }
    public int solve(int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) return dp[i][j] = 1;
        if(i>=m || j>=n) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j] = (solve(i, j+1, m, n) + solve(i+1, j, m, n));
    }
}