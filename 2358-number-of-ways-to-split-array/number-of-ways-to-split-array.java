class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int i : nums) sum += i;
        long sum1 = nums[0];
        int count = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(sum1 >= sum-sum1) count++;
            sum1 += nums[i+1];
        }
        return count;
    }
}