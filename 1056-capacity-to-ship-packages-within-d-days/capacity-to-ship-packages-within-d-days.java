class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int x : weights) {
            max = Math.max(max, x);
            sum += x;
        }
        int i = max;
        int j = sum;
        while(i<j) {
            int mid = (j-i)/2 + i;
            if(Days(weights, mid)<=days) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    private int Days(int[] arr, int x) {
        int days = 1;
        int z = x;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=x) {
                x -= arr[i];
            } else {
                days++;
                x = z;
                x -= arr[i];
            }
        }
        return days;
    }
}