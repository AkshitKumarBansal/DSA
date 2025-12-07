class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int i=0;i<=obstacleGrid.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(obstacleGrid, 0, 0);
    }
    private int solve(int[][] grid, int i, int j) {
        if(i>=grid.length || j>=grid[0].length) return dp[i][j] = 0;
        if(grid[i][j]==1) return dp[i][j] = 0;
        if(i==grid.length-1 && j==grid[0].length-1) return dp[i][j] = 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = solve(grid, i+1, j) + solve(grid, i, j+1);
    }
}