class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[m-1][n-1] == 1) return 0;
        dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(grid[i][j]==1) dp[i][j] = 0;
                else if(i==m-1 && j==n-1) continue;
                else dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}