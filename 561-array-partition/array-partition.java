class Solution {
    public int arrayPairSum(int[] nums) {
        int sum=0;
        int[] arr = new int[nums.length/2];
        Arrays.sort(nums);
        int a=0;
        for(int i=0;i<nums.length-1;i+=2){
            arr[a++]=Math.min(nums[i],nums[i+1]);
        }
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
}