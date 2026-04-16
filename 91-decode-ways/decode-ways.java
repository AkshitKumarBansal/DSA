class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        dp = new Integer[s.length()+1];
        if(s.charAt(0)=='0') return 0;
        return solve(s, 0);
    }
    private int solve(String s, int ind) {
        if(ind >= s.length()) return 1;
        if(s.charAt(ind)=='0') return 0;
        if(dp[ind] != null) return dp[ind];
        int ways = solve(s, ind + 1);
        if(ind < s.length() - 1) {
            int num = (s.charAt(ind)-'0')*10 + (s.charAt(ind+1)-'0');
            if(num <= 26) {
                ways += solve(s, ind + 2);
            }
        }

        return dp[ind] = ways;
    }
}