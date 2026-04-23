class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int pick1 = 0, noPick1 = 0;
        for(int i=n-1;i>0;i--) {
            int newPick1 = Math.max(nums[i]+noPick1, pick1);
            int newNoPick1 = pick1;
            pick1 =  newPick1;
            noPick1 = newNoPick1;
        }
        int pick2 = 0, noPick2 = 0;
        for(int i=n-2;i>=0;i--) {
            int newPick2 = Math.max(nums[i]+noPick2, pick2);
            int newNoPick2 = pick2;
            pick2 =  newPick2;
            noPick2 = newNoPick2;
        }
        return Math.max(pick1, pick2);
    }
}