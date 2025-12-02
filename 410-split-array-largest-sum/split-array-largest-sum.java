class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int x : nums) {
            sum += x;
            max = Math.max(max, x);
        }
        int i = max;
        int j = sum;
        while(i<j) {
            int mid = (j-i)/2 + i;
            if(Count(nums, mid)<=k) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    private int Count(int[] nums, int x) {
        int count = 1;
        int sum = x;
        for(int i=0;i<nums.length;i++) {
            if(x>=nums[i]) {
                x -= nums[i];
            } else {
                count++;
                x = sum;
                x -= nums[i];
            }
        }
        return count;
    }
}