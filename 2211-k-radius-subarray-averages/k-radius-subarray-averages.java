class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return nums;
        int[] res = new int[n];
        long sum = 0;
        int i = 0;
        while(i<n) {
            if(i-k<0 || i+k>=n) {
                res[i] = -1;
            }
            i++;
        }
        if(2*k+1 > n) return res;
        i = k;
        for(int j=i-k;j<=i+k;j++) {
            sum += nums[j];
        }
        int s = 2 * k + 1;
        res[i] = (int)(sum/s);
        i++;
        while(i+k<n) {
            sum = sum - nums[i-k-1] + nums[i+k];
            res[i] = (int)(sum/s);
            i++;
        }
        return res;
    }
}