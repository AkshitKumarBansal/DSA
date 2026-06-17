class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return subset(nums, 0, 0);
    } 
    private int subset(int[] nums, int ind, int xor) {
        if(ind == nums.length) return xor;
        return subset(nums, ind+1, xor^nums[ind]) + subset(nums, ind+1, xor);
    } 
}