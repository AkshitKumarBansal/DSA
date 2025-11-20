class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int x = nums[0];
        int y = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length-1;i++){
            int z = Math.max(x+nums[i], y);
            x = y;
            y = z;
        }
        int a = nums[1];
        int b = Math.max(nums[1], nums[2]);
        for(int i=3;i<nums.length;i++){
            int c = Math.max(a+nums[i], b);
            a = b;
            b = c;
        }
        return Math.max(y, b);
    }
}