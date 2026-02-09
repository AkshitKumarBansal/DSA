class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // for(int i=0;i<nums.length;i++) {
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++) {
        //         sum += nums[j];
        //         if(sum%k==0 && j-i+1>=2) return true;
        //     }
        // }
        // return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(map.containsKey(sum%k)) {
                if(i-map.get(sum%k)>=2) return true;
            } else {
                map.put(sum%k, i);
            }
        }
        return false;
    }
}