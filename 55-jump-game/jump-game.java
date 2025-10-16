class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        int cnt = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0) {
                cnt++;
            }
        }
        boolean flag = true;
        int[] zero = new int[cnt];
        int x = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]==0) zero[x++] = i;
        }
        for(int i=0;i<cnt;i++) {
            int j = zero[i]-1;
            flag = false;
            while(j >= 0) {
                if(j+nums[j]>zero[i]) {
                    flag = true;
                    break;
                }
                j--;
            }
            if(!flag) return false;
        }
        return true;
    }
}