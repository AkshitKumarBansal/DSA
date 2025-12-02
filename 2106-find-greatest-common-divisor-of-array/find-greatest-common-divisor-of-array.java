class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return GCD(max, min);
    }
    private int GCD(int max, int min) {
        if(max%min==0) return min;
        return GCD(min, max%min);
    }
}