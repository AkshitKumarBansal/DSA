class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int count = 1;
        int i=0;
        int j=0;
        while(i<nums.length-1) {
            if(nums[i]<nums[i+1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
            i++;
        }
        return max;
    }
}