class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(check(i, j, nums)) count++;
            }
        }
        return count;
    }

    private boolean check(int i, int j, int[] nums) {
        int prev = Integer.MIN_VALUE;
        for(int k=0;k<i;k++) {
            if(nums[k]<=prev) return false;
            prev = nums[k];
        }
        for(int k=j+1;k<nums.length;k++) {
            if(nums[k]<=prev) return false;
            prev = nums[k];
        }
        return true;
    }
}