class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int x = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i] <= x) {
                count += (x+1-nums[i]);
                x = x+1;
            } else {
                x = nums[i];
            }
        }
        return count;
    }
}