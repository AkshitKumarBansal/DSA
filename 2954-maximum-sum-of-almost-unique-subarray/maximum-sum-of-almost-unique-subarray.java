class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        for(int i=0;i<k;i++) {
            sum += nums.get(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        long max = 0;
        if(map.size()>=m) {
            max = sum;
        }
        int i = 1;
        int j = k;
        while(j<nums.size()) {
            map.put(nums.get(i-1), map.get(nums.get(i-1))-1);
            if(map.get(nums.get(i-1)) == 0) map.remove(nums.get(i-1));
            map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);
            sum = sum - nums.get(i-1) + nums.get(j);
            if(map.size()>=m) {
                max = Math.max(max, sum);
            }
            i++;
            j++;
        }
        return max;
    }
}