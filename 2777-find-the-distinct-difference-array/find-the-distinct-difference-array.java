class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> prefix = new HashSet<>();
        Map<Integer, Integer> suffix = new HashMap<>();
        for(int i=0;i<nums.length;i++) suffix.put(nums[i], suffix.getOrDefault(nums[i], 0)+1);
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            prefix.add(nums[i]);
            suffix.put(nums[i], suffix.get(nums[i])-1);
            if(suffix.get(nums[i])==0) suffix.remove(nums[i]);
            ans[i] = prefix.size()-suffix.size();
        }
        return ans;
    }
}