class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][3];
        for(int i=n-1;i>=0;i--) {
            for(int j=2;j>0;j--) {
                dp[i][0][j] = Math.max(prices[i]+dp[i+1][1][j-1], dp[i+1][0][j]);
                dp[i][1][j] = Math.max(-prices[i]+dp[i+1][0][j], dp[i+1][1][j]);
            }
        }
        return dp[0][1][2];
    }
    // private int solve(int[] arr, int ind, int buy, int k) {
    //     if(k==0 || ind==arr.length) return 0;
    //     if(dp[ind][buy][k]!=null) return dp[ind][buy][k];
    //     int profit = 0;
    //     if(buy != 0) {
    //         profit = Math.max(-arr[ind]+solve(arr, ind+1, 0, k), solve(arr, ind+1, 1, k));
    //     } else {
    //         profit = Math.max(arr[ind]+solve(arr, ind+1, 1, k-1), solve(arr, ind+1, 0, k));
    //     }
    //     return dp[ind][buy][k] = profit;
    // }
}