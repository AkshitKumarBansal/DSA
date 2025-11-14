class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int steps = 0;
        int i = 0;
        while(i < nums.length-1) {
            steps++;
            i = helper(nums, nums[i], i);
        }
        return steps;
    }
    private int helper(int[] arr, int val, int ind) {
        int max = Integer.MIN_VALUE;
        int index = ind+1;
        while(val != 0) {
            if(ind+val<arr.length-1 && max<val+arr[ind+val]) {
                max = Math.max(max, val+arr[ind+val]);
                index = ind+val;
            } else if(ind+val == arr.length-1){
                index = arr.length-1;
                break;
            }
            val--;
        }
        return index;
    }
}