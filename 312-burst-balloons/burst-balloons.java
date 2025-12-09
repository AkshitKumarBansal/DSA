class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        dp = new Integer[nums.length+2][nums.length+2];
        int[] arr = new int[nums.length+2];
        for(int i=1;i<arr.length-1;i++) {
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[arr.length-1] = 1;
        return solve(1, nums.length, arr);
    }
    private int solve(int i, int j, int[] arr) {
        if(i>j) return dp[i][j] = 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = 0;
        for(int k=i;k<=j;k++) {
            int temp = solve(i, k-1, arr) + solve(k+1, j, arr) + (arr[i-1]*arr[k]*arr[j+1]);
            ans = Math.max(ans, temp);
        }
        return dp[i][j] = ans;
    }
}