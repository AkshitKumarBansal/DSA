class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n+1];
        return solve(nums, 0);
    }
    private boolean solve(int[] arr, int ind) {
        if(ind >= arr.length-1) return true;
        if(dp[ind]!=null) return dp[ind];
        if(arr[ind]==0) return dp[ind] = false;
        for(int i=1;i<=arr[ind] && i<=arr.length;i++) {
            if(solve(arr, ind + i)) {
                return dp[ind] = true;
            }
        }
        return dp[ind] = false;
    }
}

// Memoized Code