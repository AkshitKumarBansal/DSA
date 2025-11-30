class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i=0;i<k;i++) {
            sum += nums[i];
        }
        long max = 0;
        if(map.size()==k) {
            max = sum;
        }
        int i = 1;
        int j = k+1;
        while(j<=nums.length) {
            map.put(nums[i-1], map.get(nums[i-1]) - 1);
            if(map.get(nums[i-1])==0) map.remove(nums[i-1]);
            map.put(nums[j-1], map.getOrDefault(nums[j-1], 0) + 1);
            sum = sum - nums[i-1] + nums[j-1];
            if(map.size()==k) {
                max = Math.max(max, sum);
            }
            i++;
            j++;
        }
        return max;
    }
}