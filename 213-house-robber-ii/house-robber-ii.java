class Solution {
    Integer[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        dp = new Integer[n+1][2];
        int ans1 = solve(nums, 0, 0, n-1);
        dp = new Integer[n][2];
        int ans2 = solve(nums, 1, 0, n);
        return Math.max(ans1, ans2);
    }
    private int solve(int[] arr, int ind, int rob, int end) {
        if(ind==end) return 0;
        if(dp[ind][rob]!=null) return dp[ind][rob];
        int cash = 0;
        if(rob==0) {
            cash = Math.max(arr[ind]+solve(arr, ind+1, 1, end), solve(arr, ind+1, 0, end));
        } else {
            cash = solve(arr, ind+1, 0, end);
        }
        return dp[ind][rob] = cash;
    }
}