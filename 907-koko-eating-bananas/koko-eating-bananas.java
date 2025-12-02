class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int x : piles) max = Math.max(x, max);
        int i = 1;
        int j = max;
        while(i<j) {
            int mid = (j-i)/2+i;
            if(Sum(piles, mid) <= h) {
                j = mid;
            } else {
                i = mid+1;
            }
        }
        return i;
    }
    private int Sum(int[] piles, int x) {
        int sum = 0;
        for(int y : piles) {
            if(y%x==0) {
                sum += (y/x);
            } else {
                sum += (y/x)+1;
            }
        }
        return sum;
    }
}