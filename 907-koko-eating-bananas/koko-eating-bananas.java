class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int n = piles.length;
        for(int i : piles) max = Math.max(max, i);
        int left = 1, right = max;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(solve(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int solve(int[] piles, int value) {
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i]%value == 0) count += piles[i]/value;
            else count += piles[i]/value + 1;
        }
        return count;
    }
}