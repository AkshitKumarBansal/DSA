class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            boolean flag = false;
            for(int j=i+1;j<2*nums.length-1;j++) {
                if(nums[i]<nums[j%nums.length]) {
                    res[i] = nums[j%nums.length];
                    flag = true;
                    break;
                }
            }
            if(!flag) res[i] = -1;
        }
        return res;
    }
}