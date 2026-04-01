class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1;
        while(i<=j) {
            while(i<=j && nums[i]%2!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j -= 2;
            }
            i += 2;
        }
        i = 1; j = n-2;
        while(i<=j) {
            while(i<=j && nums[i]%2==0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j -= 2;
            }
            i += 2;
        }
        return nums;
    }
}