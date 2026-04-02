class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum%2!=0) return false;
        dp = new Boolean[nums.length+1][sum/2+1];
        return solve(0, nums, sum/2);
    }
    private boolean solve(int ind, int[] arr, int sum) {
        if(sum == 0) return dp[ind][sum] = true;
        if(ind >= arr.length) return dp[ind][sum] = false;
        if(dp[ind][sum] != null) return dp[ind][sum];
        boolean noPick = solve(ind+1, arr, sum);
        boolean Pick = false;
        if(arr[ind]<=sum) Pick = solve(ind+1, arr, sum-arr[ind]);
        return dp[ind][sum] = (noPick || Pick);
    }
}