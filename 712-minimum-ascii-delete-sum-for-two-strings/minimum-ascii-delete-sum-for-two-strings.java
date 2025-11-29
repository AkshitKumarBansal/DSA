class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = (int)s1.charAt(i-1) + dp[i-1][j-1];
                    if(i>1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    }
                    if(j>1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int max = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return freq(s1) + freq(s2) - 2*max;
    }
    private int freq(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += (int)c;
        }
        return sum;
    }
}