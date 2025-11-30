class Solution {
    public int minSwaps(int[] nums) {
        int count1 = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) count1++;
        }
        int count = 0;
        for(int i=0;i<count1;i++) {
            if(nums[i]==1) count++;
        }
        int max = count;
        int i = 1;
        int j = count1;
        while(j<nums.length+count1) {
            if(j<nums.length) {
                if(nums[i-1]==1 && nums[j]==0) {
                    count--;
                } else if(nums[i-1]==0 && nums[j]==1) {
                    count++;
                }
            } else {
                if(nums[i-1]==1 && nums[j-nums.length]==0) {
                    count--;
                } else if(nums[i-1]==0 && nums[j-nums.length]==1) {
                    count++;
                }
            }
            i++;
            j++;
            max = Math.max(max, count);
        }
        return count1 - max;
    }
}