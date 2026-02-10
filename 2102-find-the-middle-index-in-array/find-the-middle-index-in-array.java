class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        int sum1 = 0;
        for(int i=0;i<nums.length;i++) {
            if(sum1 == sum-sum1-nums[i]) return i;
            sum1 += nums[i];
        }
        return -1;
    }
}