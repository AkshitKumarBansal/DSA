class Solution {
    Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new Integer[n+1][n+1];
        StringBuilder sb = new StringBuilder(s);
        return solve(0, 0, n, s, sb.reverse().toString());
    }
    private int solve(int i, int j, int n, String s1, String s2) {
        if(i==n || j==n) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1 + solve(i+1, j+1, n, s1, s2);
        return dp[i][j] = Math.max(solve(i+1, j, n, s1, s2), solve(i, j+1, n, s1, s2));
    }
}