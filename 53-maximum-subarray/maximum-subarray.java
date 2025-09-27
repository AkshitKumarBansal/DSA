class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        // for(int i=0;i<nums.length;i++) {
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++) {
        //         sum += nums[j];
        //         if(sum > max){
        //             max = sum;
        //         }
        //     }
        // }
        int x = nums[0];
        for(int i=1;i<nums.length;i++){
            x = Math.max(x+nums[i], nums[i]);
            max = Math.max(max, x);
        }
        return max;
    }
}