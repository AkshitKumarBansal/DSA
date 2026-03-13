class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int x : nums) set.add(x);
        for(int num : set) {
            if(!set.contains(num-1)) {
                int curr = num;
                int count = 1;
                while(set.contains(curr+1)) {
                    count++;
                    curr++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}