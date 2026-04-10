class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) count++;
            if(nums[i]==0) {
                max = Math.max(max, solve(nums, i+1)+ count);
                count = 0;
            }
        }
        return Math.max(max, count-1);
    }
    private int solve(int[] nums, int ind) {
        int count = 0;
        for(int i=ind;i<nums.length;i++) {
            if(nums[i]==1) count++;
            else break;
        }
        return count;
    }
}