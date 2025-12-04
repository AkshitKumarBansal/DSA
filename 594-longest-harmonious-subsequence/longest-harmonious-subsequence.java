class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        if(nums[nums.length-1]-nums[0]==0) return 0;
        int i = 0;
        int j = 0;
        int max = 0;
        while(j<nums.length) {
            if(nums[i]==nums[j]) {
                j++;
            } else if(nums[j]-nums[i]==1) {
                j++;
                max = Math.max(max, j-i);
            } else if(nums[j]-nums[i]>1) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        return max;
    }
}