class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += (i*nums[i]);
        }
        int max = sum;
        int f = sum;
        sum = 0;
        for(int i : nums) sum += i;
        for(int i=1;i<n;i++) {
            f = f + sum - (nums[n-i]*n);
            max = Math.max(max, f);
        }
        return max;
    }
}

// Optimized Solution