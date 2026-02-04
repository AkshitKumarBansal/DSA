class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int count = nums.length;
        for(int x : nums) {
            if(x != 0) {
                prod *= x;
                count--;
            }
        }
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(count == 0) {
                arr[i] = prod/nums[i];
            } else if(count == 1) {
                if(nums[i]==0) {
                    arr[i] = prod;
                } else {
                    arr[i] = 0;
                }
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }
}