class Solution {
    Integer[] dp;
    public int minCut(String s) {
        int n = s.length();
        if(n == 1) return 0;
        dp = new Integer[n+1];
        int count = solve(s, 0);
        return count - 1;
    }
    private int solve(String s, int i) {
        if(i == s.length()) return 0;
        if(dp[i] != null) return dp[i];
        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (check(s, i, j)) {
                int cuts = 1 + solve(s, j+1);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return dp[i] = minCuts;
    }
    
    private boolean check(String s, int i, int j) {
        int left = i, right = j;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}