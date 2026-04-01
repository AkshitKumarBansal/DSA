class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int firstPos = firstGreater(nums, 0);
        int firstZero = firstGreaterEqual(nums, 0);
        int negCount = firstZero;
        int posCount = n - firstPos;
        return Math.max(negCount, posCount);
    }
    private int firstGreater(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    private int firstGreaterEqual(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}