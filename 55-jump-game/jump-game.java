class Solution {
    boolean[] dp;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new boolean[n+1];
        dp[n-1] = true;
        for(int i=n-2;i>=0;i--) {
            for(int j=1;j<=nums[i] && i+j<n;j++) {
                if(dp[i+j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}

// Tabulation Code