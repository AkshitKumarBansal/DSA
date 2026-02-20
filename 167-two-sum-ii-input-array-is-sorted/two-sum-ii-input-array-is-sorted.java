class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i=0,j=n-1;
        int[] ans = {-1,-1};
        while(i<j) {
            if(numbers[i]+numbers[j]==target) {
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            } else if(numbers[i]+numbers[j]<target) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}