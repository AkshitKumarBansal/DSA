class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] sort = nums.clone();
        Arrays.sort(sort);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(!map.containsKey(sort[i])) map.put(sort[i], i);
        }
        for(int i=0;i<n;i++) {
            ans[i] = map.get(nums[i]);
        }
        // for(int i=0;i<n;i++) {
        //     int count = 0;
        //     for(int j=0;j<n;j++) if(nums[i]>nums[j]) count++;
        //     ans[i] = count;
        // }
        return ans;
    }
}