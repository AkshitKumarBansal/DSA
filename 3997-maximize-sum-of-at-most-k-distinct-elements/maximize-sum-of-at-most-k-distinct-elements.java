class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        int[] ans = new int[k];
        Arrays.sort(nums);
        int i = nums.length-1;
        int j = 0;
        while (i >= 0 && j < k) {
            ans[j++] = nums[i];
            int curr = nums[i];
            while (i >= 0 && nums[i] == curr) i--;
        }
        return Arrays.copyOfRange(ans, 0, j);
    }
}