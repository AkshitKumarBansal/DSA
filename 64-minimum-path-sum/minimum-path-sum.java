class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<=grid.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(grid, 0, 0);
    }
    private int solve(int[][] grid, int i, int j) {
        if(i==grid.length-1 && j==grid[0].length-1) return dp[i][j] = grid[i][j];
        if(i>=grid.length || j>=grid[0].length) return dp[i][j] = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(solve(grid, i+1, j), solve(grid, i, j+1));
    }
}