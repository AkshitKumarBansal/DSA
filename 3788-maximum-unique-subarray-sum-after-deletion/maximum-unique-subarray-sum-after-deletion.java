class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int sum = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int x : set) {
            if(x >= 0) {
                sum += x;
                count++;
            }
            else {
                max = Math.max(max, x);
            }
        }
        return (count==0) ? max : sum;
    }
}