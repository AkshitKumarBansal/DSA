class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++) max = Math.max(nums[i], max);
        for(int i=1;i<=max;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(i<=nums[j]) count++;
            }
            if(count==i) return i;
        }
        return -1;
    }
}