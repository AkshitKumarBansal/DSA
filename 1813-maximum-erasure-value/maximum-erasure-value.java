class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        int left = 0, n = nums.length;
        for(int right=0;right<n;right++) {
            while(left < right && map.containsKey(nums[right])) {
                sum -= nums[left];
                map.remove(nums[left]);
                left++;
            }
            map.put(nums[right], 1);
            sum += nums[right];
            max = Math.max(max, sum);
                
        }
        return max;
    }
}