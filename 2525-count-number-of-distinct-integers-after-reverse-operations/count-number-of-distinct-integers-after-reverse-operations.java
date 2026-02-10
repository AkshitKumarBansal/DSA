class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
            set.add(Reverse(i));
        }
        return set.size();
    }
    public int Reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = (rev*10) + (n%10);
            n /= 10;
        }
        return rev;
    }
}