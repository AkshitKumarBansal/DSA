class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length+1][2];
        return solve(prices, 1, 0);
    }
    private int solve(int[] arr, int buy, int ind) {
        if(ind == arr.length) return 0;
        if(dp[ind][buy] != null) return dp[ind][buy];
        int profit = 0;
        if(buy != 0) {
            profit = Math.max(-arr[ind]+solve(arr, 0, ind+1), solve(arr, 1, ind+1));
        } else {
            profit = Math.max(arr[ind]+solve(arr, 1, ind+1), solve(arr, 0, ind+1));
        }
        return dp[ind][buy] = profit;
    }
}