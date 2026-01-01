class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int x = -1;
        for(int i=0;i<nums.length;i++) {
            if(max < nums[i]) {
                max = nums[i];
                x = i;
            }
        }
        int smax = Integer.MIN_VALUE;
        for(int i : nums) {
            if(i<max) {
                smax = Math.max(smax, i);
            }
        }
        return (max >= 2*smax) ? x : -1; 
    }
}