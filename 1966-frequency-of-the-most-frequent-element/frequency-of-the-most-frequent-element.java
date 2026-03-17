class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0;
        int j=0;
        long sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            while((long)(i-j+1)*nums[i]-sum > k) {
                sum -= nums[j];
                j++;
            }
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}