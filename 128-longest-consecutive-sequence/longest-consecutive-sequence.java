class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int i : nums) set.add(i);
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while(set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}