class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++) dp[i][0] = 0;
        for(int j=1;j<=amount;j++) dp[0][j] = (int)1e9;
        for(int i=1;i<=coins.length;i++) {
            for(int j=1;j<=amount;j++) {
                if(coins[i-1]<=j) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (dp[coins.length][amount]>=(int)1e9) ? -1 : dp[coins.length][amount];
    }
}