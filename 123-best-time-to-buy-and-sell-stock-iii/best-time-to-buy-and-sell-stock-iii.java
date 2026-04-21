class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n+1][2][3];
        return solve(prices, 0, 1, 2);
    }
    private int solve(int[] arr, int ind, int buy, int k) {
        if(k==0 || ind==arr.length) return 0;
        if(dp[ind][buy][k]!=null) return dp[ind][buy][k];
        int profit = 0;
        if(buy != 0) {
            profit = Math.max(-arr[ind]+solve(arr, ind+1, 0, k), solve(arr, ind+1, 1, k));
        } else {
            profit = Math.max(arr[ind]+solve(arr, ind+1, 1, k-1), solve(arr, ind+1, 0, k));
        }
        return dp[ind][buy][k] = profit;
    }
}