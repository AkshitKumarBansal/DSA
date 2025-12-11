class Solution {
    private int min = 0;
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size()];
        return solve(0, 0, triangle.size(), triangle);
    }
    private int solve(int i, int j, int m, List<List<Integer>> list) {
        if(i==m) return 0;
        if(dp[i][j] != null) return dp[i][j];
        min = list.get(i).get(j) + Math.min(solve(i+1, j, m, list), solve(i+1, j+1, m, list));
        return dp[i][j] = min;
    }
}