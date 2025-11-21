class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(target>sum) return 0;
        int[][] dp = new int[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++) dp[i][0] = 1;
        for(int i=1;i<=nums.length;i++) {
            for(int j=0;j<=sum;j++) {
                if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if((target+sum)%2!=0) return 0;
        int sum1 = (target+sum)/2;
        if(sum1>sum || sum1<0) return 0;
        return dp[nums.length][sum1];
    }
}