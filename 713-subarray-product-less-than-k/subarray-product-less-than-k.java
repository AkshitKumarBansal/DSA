class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        for(int i=0;i<nums.length;i++) {
            int ans = 1;
            for(int j=i;j<nums.length;j++) {
                ans = ans*nums[j];
                if(ans < k){
                    cnt++;
                }
                else {
                    break;
                }
            }
        }
        return cnt;
    }
}