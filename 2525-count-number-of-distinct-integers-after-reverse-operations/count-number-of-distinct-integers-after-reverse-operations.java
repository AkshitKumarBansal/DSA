class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
            int rev = 0;
            int n = nums[i];
            while (n != 0) {
                int digit = n % 10;
                rev = rev * 10 + digit;
                n /= 10;
            }
            set.add(rev);
        }
        return set.size();
    }
}