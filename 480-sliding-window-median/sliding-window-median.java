class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new double[0];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int l = 1, r = k;
        double[] res = new double[nums.length-k+1];
        res[0] = solve(list, k);
        while(r < nums.length) {
            list.remove(Integer.valueOf(nums[l-1]));
            int ind = Collections.binarySearch(list, nums[r]);
            if(ind < 0) {
                ind = -ind - 1;
            }
            list.add(ind, nums[r]);
            res[l] = solve(list, k);
            l++;
            r++;
        }
        return res;
    }
    private static double solve(List<Integer> list, int k) {
        double median = 0;
        if(k%2==1) median = (double)list.get(list.size()/2);
        else {
            median = ((double)list.get(list.size()/2) + (double)list.get(list.size()/2-1))/2;
        }
        return median;
    }
}