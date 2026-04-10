class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int i = 0;
        int prev = 0;
        while (i < n) {
            int left = 0;
            while (i < n && nums[i] == 1) {
                left++;
                i++;
            }
            if (i < n) {
                int right = solve(nums, i + 1);
                max = Math.max(max, left + right);
                prev = left;
                i++;
            } else {
                max = Math.max(max, left - 1);
            }
        }
        return max;
    }
    private int solve(int[] nums, int ind) {
        int cnt = 0;
        while (ind < nums.length && nums[ind] == 1) {
            cnt++;
            ind++;
        }
        return cnt;
    }
}