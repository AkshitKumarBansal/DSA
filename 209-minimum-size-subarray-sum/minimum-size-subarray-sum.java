class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1;
        // for(int i=0;i<nums.length;i++) {
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++) {
        //         sum += nums[j];
        //         if(sum >= target) {
        //             min = Math.min(j-i+1,min);
        //             break;
        //         }
        //     }
        // }
        // return (min == nums.length+1) ? 0 : min;
        int i=0;
        int j=0;
        int sum = 0;
        int size = nums.length+1;
        while(j<nums.length && i<nums.length) {
            sum += nums[j];
            if(sum >= target){
                size = j-i+1;
                min = Math.min(size, min);
                sum = sum - nums[i] - nums[j];
                i++;
                j--;
            }
            j++;
        }
        return (min == nums.length+1) ? 0 : min;
    }
}