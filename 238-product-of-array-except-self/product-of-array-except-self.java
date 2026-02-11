class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = nums[0];
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1;i<nums.length;i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for(int i=nums.length-1;i>=0;i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }
}