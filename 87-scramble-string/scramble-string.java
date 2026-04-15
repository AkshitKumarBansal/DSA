class Solution {
    Boolean[][][] dp;
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        dp = new Boolean[n][n][n+1];
        return solve(s1, s2, 0, 0, n);
    }
    private boolean solve(String s1, String s2, int i, int j, int len) {
        if(dp[i][j][len] != null) return dp[i][j][len];
        boolean flag = true;
        for (int k = 0; k < len; k++) {
            if (s1.charAt(i + k) != s2.charAt(j + k)) {
                flag = false;
                break;
            }
        }
        if(flag) dp[i][j][len] = true;
        for(int k=1;k<len;k++) {
            if (solve(s1, s2, i, j, k) &&
                solve(s1, s2, i + k, j + k, len - k)) {
                flag = true;
                break;
            }
            if (solve(s1, s2, i, j + len - k, k) &&
                solve(s1, s2, i + k, j, len - k)) {
                flag = true;
                break;
            }
        }
        return dp[i][j][len] = flag;
    }
}