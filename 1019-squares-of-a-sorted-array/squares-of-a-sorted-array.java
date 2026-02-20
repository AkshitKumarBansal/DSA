class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i=0,j=n-1,a=n-1;
        int[] ans = new int[n];
        while(i<=j) {
            int left = nums[i]*nums[i];
            int right = nums[j]*nums[j];
            if(left>right) {
                ans[a--] = left;
                i++;
            } else {
                ans[a--] = right;
                j--;
            }
        }
        return ans;
    }
}