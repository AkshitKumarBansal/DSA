class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left = 0;
        int count = 0, sum = 0, zeroes = 0;
        for(int right=0;right<n;right++) {
            sum += nums[right];
            while (left < right && sum > goal) {
                sum -= nums[left];
                left++;
                zeroes = 0;
            }
            while (left < right && nums[left] == 0 && sum == goal) {
                zeroes++;
                sum -= nums[left];
                left++;
            }
            if(sum == goal) count += 1 + zeroes;
        }
        return count;
    }
}