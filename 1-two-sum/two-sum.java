class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int part = target-nums[i];
            if(mp.containsKey(part)) return new int[]{i, mp.get(part)};
            mp.put(nums[i], i);
        }
        return ans;
    }
}