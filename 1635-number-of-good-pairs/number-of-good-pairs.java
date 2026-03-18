class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.containsKey(nums[i])) count+=map.get(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         if(nums[i]==nums[j]) count++;
        //     }
        // }
        return count;
    }
}