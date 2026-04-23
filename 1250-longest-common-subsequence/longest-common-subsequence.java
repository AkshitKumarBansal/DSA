class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new Integer[m+1][n+1];
        return solve(0, 0, m, n, text1, text2);
    }
    private int solve(int i, int j, int m, int n, String s1, String s2) {
        if(i==m || j==n) return dp[i][j] = 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1 + solve(i+1, j+1, m, n, s1, s2);
        else return dp[i][j] = Math.max(solve(i+1, j, m, n, s1, s2), solve(i, j+1, m, n, s1, s2));
    }
}