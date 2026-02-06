class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || k<=0) return 0;
        double sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        double avg = sum/k;
        double maxAvg = avg;
        for(int i=k; i<nums.length; i++){
            sum += nums[i] - nums[i-k];
            avg = sum / k;
            if(avg > maxAvg) {
                maxAvg = avg;
            }
        }
        return maxAvg;
    }
}