class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[nums.length-1];
        int i=0;
        int j=k;
        while(j<=nums.length) {
            min = Math.min(min, nums[j-1]-nums[i]);
            i++;
            j++;
        }
        return min;
    }
}