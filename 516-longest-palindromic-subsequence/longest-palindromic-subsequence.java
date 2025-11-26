class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int[][] dp = new int[s.length()+1][sb.length()+1];
        for(int i=1;i<=s.length();i++) {
            for(int j=1;j<=sb.length();j++) {
                if(s.charAt(i-1)==sb.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][sb.length()];
    }
}