class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int x : stones) sum += x;
        int n = stones.length;
        boolean[][] dp = new boolean[n+1][sum/2+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum/2;j++) {
                dp[i][j] = dp[i-1][j];
                if(stones[i-1]<=j) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-stones[i-1]];
                }
            }
        }
        int max = 0;
        for(int j=1;j<=sum/2;j++) {
            if(dp[n][j]) max = j;
        }
        return sum-2*max;
    }
}