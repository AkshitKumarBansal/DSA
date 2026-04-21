class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>=0;i--) {
            dp[i][1] = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
            dp[i][0] = Math.max(prices[i]+dp[i+1][1], dp[i+1][0]);
        }
        return  dp[0][1];
    }
    // private int solve(int[] arr, int buy, int ind) {
    //     if(ind == arr.length) return 0;
    //     if(dp[ind][buy] != null) return dp[ind][buy];
    //     int profit = 0;
    //     if(buy != 0) {
    //         profit = Math.max(-arr[ind]+solve(arr, 0, ind+1), solve(arr, 1, ind+1));
    //     } else {
    //         profit = Math.max(arr[ind]+solve(arr, 1, ind+1), solve(arr, 0, ind+1));
    //     }
    //     return dp[ind][buy] = profit;
    // }
}