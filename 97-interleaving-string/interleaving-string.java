class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        int a = s1.length();
        int b = s2.length();
        dp = new Boolean[a+1][b+1];
        return SubSequence(s1, s2, s3, a, b);
    }
    private boolean SubSequence(String s1, String s2, String s3, int i, int j) {
        if(i==0 && j==0) {
            return true;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int k = i + j - 1;
        boolean result = false;
        if(i > 0 && s1.charAt(i-1)==s3.charAt(k)) {
            result = SubSequence(s1, s2, s3, i-1, j);
        }
        if(!result && j > 0 && s2.charAt(j-1)==s3.charAt(k)) {
            result = SubSequence(s1, s2, s3, i, j-1);
        }
        return dp[i][j] = result;
    }
}