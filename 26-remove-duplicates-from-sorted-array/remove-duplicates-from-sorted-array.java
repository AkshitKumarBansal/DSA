class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int count = 1;
        while(j<nums.length) {
            if(nums[i]!=nums[j]) {
                i = j;
                nums[count++] = nums[i];
            }
            j++;
        }
        return count;
    }
}