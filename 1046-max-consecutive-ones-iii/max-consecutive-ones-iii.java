class Solution {
    public int longestOnes(int[] nums, int k) {
        int count1 = 0;
        int count0 = 0;
        int l = 0, r = 0, maxLen = 0;
        while(r<nums.length) {
            if((count0 < k) || (count0 == k && nums[r]!=0)) {
                if(nums[r]==0) count0++;
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            } else {
                if(nums[l]==0) count0--;
                l++;
            }
        }
        return maxLen;
    }
}