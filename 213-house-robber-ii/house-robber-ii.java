class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[][] dp = new int[n+1][2];
        for(int i=n-1;i>0;i--) {
            dp[i][0] = Math.max(nums[i]+dp[i+1][1], dp[i+1][0]);
            dp[i][1] = dp[i+1][0];
        }
        int ans1 = dp[1][0];
        dp = new int[n][2];
        for(int i=n-2;i>=0;i--) {
            dp[i][0] = Math.max(nums[i]+dp[i+1][1], dp[i+1][0]);
            dp[i][1] = dp[i+1][0];
        }
        int ans2 = dp[0][0];
        return Math.max(ans1, ans2);
    }
    // private int solve(int[] arr, int ind, int rob, int end) {
    //     if(ind==end) return 0;
    //     if(dp[ind][rob]!=null) return dp[ind][rob];
    //     int cash = 0;
    //     if(rob==0) {
    //         cash = Math.max(arr[ind]+solve(arr, ind+1, 1, end), solve(arr, ind+1, 0, end));
    //     } else {
    //         cash = solve(arr, ind+1, 0, end);
    //     }
    //     return dp[ind][rob] = cash;
    // }
}