class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, left = 0;
        int max = 0;
        while(i<n && nums[i]!=0) {
            left++;
            i++;
        }
        while(i<n) {
            int right = 0, j = i + 1;
            while(j<n && nums[j]!=0) {
                right++;
                j++;
            }
            max = Math.max(max, right+left);
            left = right;
            i = i + right + 1; 
        }
        return Math.max(max, left-1);
    }
}