class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(max >= nums.length-1) return true;
            if(nums[i]==0) {
                if(max <= i) return false;
                else max = Math.max(nums[i]+i, max);
            } else {
                max = Math.max(nums[i]+i, max);
            }
        }
        return true;
    }
}

// Greedy Approach