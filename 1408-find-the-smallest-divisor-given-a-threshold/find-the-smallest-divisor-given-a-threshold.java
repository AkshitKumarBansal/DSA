class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int x : nums) max = Math.max(x, max);
        int i = 1;
        int j = max;
        while(i<j) {
            int mid = (j-i)/2 + i;
            if(Sum(nums, mid)<=threshold) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    private int Sum(int[] nums, int x) {
        int sum = 0;
        for(int y : nums) {
            if(y%x==0) {
                sum += y/x;
            } else {
                sum += (y/x)+1;
            }
        }
        return sum;
    }
}