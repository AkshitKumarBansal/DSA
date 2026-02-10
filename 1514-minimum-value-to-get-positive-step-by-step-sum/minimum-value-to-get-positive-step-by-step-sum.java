class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        return (min <= 0) ? min*-1 + 1 : 1;
    }
}