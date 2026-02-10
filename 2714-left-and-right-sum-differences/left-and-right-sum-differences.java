class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        int sum1 = 0;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            ans[i] = Math.abs((sum - sum1 - nums[i]) - sum1);
            sum1 += nums[i];
        }
        return ans;
    }
}