class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        return (max+k-1)*(max+k)/2 - max*(max-1)/2;
    }
}