class Solution {
    Integer[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1][2];
        return solve(nums, 0, 0);
    }
    private int solve(int[] arr, int ind, int rob) {
        if(ind == arr.length) return 0;
        if(dp[ind][rob]!=null) return dp[ind][rob];
        int cash = 0;
        if(rob == 0) {
            cash = Math.max(arr[ind]+solve(arr, ind+1, 1), solve(arr, ind+1, 0));
        } else {
            cash = solve(arr, ind+1, 0);
        }
        return dp[ind][rob] = cash;
    }
}