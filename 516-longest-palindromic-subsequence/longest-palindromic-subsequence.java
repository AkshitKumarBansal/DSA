class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        for(int i=n-1;i>=0;i--) {
            int val = 0;
            for(int j=n-1;j>=0;j--) {
                int temp = dp[j];
                if(s.charAt(i)==sb.charAt(j)) dp[j] = 1 + val;
                else dp[j] = Math.max(dp[j], dp[j+1]);
                val = temp;
            }
        }
        return dp[0];
    }
}