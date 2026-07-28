class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()];
        return solve(s, 0, 0); 
    }
    private boolean solve(String s, int ind, int count) {
        if(ind == s.length()) {
            return count == 0;
        }
        if(count < 0) return false;
        if(dp[ind][count] != null) return dp[ind][count];
        boolean result = false;
        if(s.charAt(ind) == '(') result = solve(s, ind+1, count+1);
        else if(s.charAt(ind) == ')') result = solve(s, ind+1, count-1);
        else {
            boolean left = solve(s, ind+1, count+1);
            boolean right = solve(s, ind+1, count-1);
            boolean empty = solve(s, ind+1, count);
            result = left | right | empty;
        }
        return dp[ind][count] = result;
    }
}