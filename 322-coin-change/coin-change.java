class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        dp = new Integer[coins.length+1][amount+1];
        int result = solve(0, coins, amount);
        return (result==Integer.MAX_VALUE) ? -1 : result;
    }
    private int solve(int ind, int[] coins, int amount) {
        if(amount==0) return dp[ind][amount] = 0;
        if(ind == coins.length) return Integer.MAX_VALUE;
        if(dp[ind][amount] != null) return dp[ind][amount];
        int noPick = solve(ind+1, coins, amount);
        int pickWait = Integer.MAX_VALUE, pickNext = Integer.MAX_VALUE;
        if(coins[ind]<=amount) {
            int res1 = solve(ind, coins, amount - coins[ind]);
            if(res1 != Integer.MAX_VALUE) {
                pickWait = 1 + res1;
            }
            int res2 = solve(ind+1, coins, amount - coins[ind]);
            if(res2 != Integer.MAX_VALUE) {
                pickNext = 1 + res2;
            }
        }
        return dp[ind][amount] = Math.min(noPick, Math.min(pickWait, pickNext));
    }
}