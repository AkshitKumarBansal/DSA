class Solution {
    private Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()];
        return solve(0, 0, s, p);
    }
    private boolean solve(int i, int j, String s, String p) {
        if(i==s.length() && j==p.length()) return true;
        if(j==p.length()) return false;
        if(dp[i][j]!=null) return dp[i][j];
        boolean flag = (i<s.length() && (s.charAt(i)==p.charAt(j) || i<s.length() && p.charAt(j)=='.'));
        if(j<p.length()-1 && p.charAt(j+1)=='*') {
            return dp[i][j] = (solve(i, j + 2, s, p) || (flag && solve(i+1, j, s, p))) ;
        }
        if(flag) {
            return dp[i][j] = solve(i+1, j+1, s, p);
        }
        return dp[i][j] = false;
    }
}