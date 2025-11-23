class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum%k!=0) return false;
        int sum1 = sum/k;
        boolean[] flag = new boolean[nums.length];
        return backtrack(nums, flag, k, 0, 0, sum1);
    }
    private boolean backtrack(int[] nums, boolean[] flag, int k, int ind, int sum, int target) {
        if(k==1) return true;
        if(sum == target) {
            return backtrack(nums, flag, k - 1, 0, 0, target);
        }
        for(int i=ind;i<nums.length;i++) {
            if(flag[i]) continue;
            if(sum+nums[i]<=target) {
                flag[i] = true;
                if(backtrack(nums, flag, k, ind+1, sum+nums[i], target)) {
                    return true;
                }
                flag[i] = false;
            }
            if(sum==0) break;
        }
        return false;
    }
}