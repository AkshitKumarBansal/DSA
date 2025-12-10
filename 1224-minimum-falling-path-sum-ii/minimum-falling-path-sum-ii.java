class Solution {
    Integer[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        dp = new Integer[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            int temp = solve(0, i, grid.length, grid[0].length, grid);
            min = Math.min(min, temp);
        }
        return min;
    }
    private int solve(int i, int j, int m, int n, int[][] arr) {
        if(i<0 || j<0 || i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1) return dp[i][j] = arr[i][j];
        if(dp[i][j] != null) return dp[i][j];
        int sum = Integer.MAX_VALUE;
        for(int k=0;k<n;k++) {
            if(k!=j) {
                int temp = arr[i][j] + solve(i+1, k, m, n, arr);
                sum = Math.min(sum, temp);
            }
        }
        return dp[i][j] = sum;
    }
}