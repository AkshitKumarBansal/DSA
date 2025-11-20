class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ind = 0;
        for(int i=0;i<nums.length;i++) {
            if(max<nums[i]) {
                max = nums[i];
                ind = i;
            }
        }
        int smax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(smax<nums[i] && i!=ind) {
                smax =  nums[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            min = Math.min(min, nums[i]);
        }
        return max+smax-min;
    }
}