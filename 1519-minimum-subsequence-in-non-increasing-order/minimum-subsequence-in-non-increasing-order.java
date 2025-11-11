class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = nums.length-1;
        int sum = 0;
        for(int num : nums) sum += num;
        int sum1 = 0;
        while(sum1 <= (sum/2) && i >= 0) {
            sum1 += nums[i];
            list.add(nums[i]);
            i--;
        }
        return list;
    }
}