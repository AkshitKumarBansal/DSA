class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int rob = 0, noRob = 0;
        for(int i=n-1;i>=0;i--) {
            int newRob = Math.max(nums[i]+noRob, rob);
            int noNewRob = rob;
            rob = newRob;
            noRob = noNewRob;
        }
        return rob;
    }
}