class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = nums1.length;
        for(int i=0;i<n;i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+1);
            set.add(nums1[i]);
            set.add(nums2[i]);
        }
        int cost = 0;
        for(int num : set) {
            int freq1 = map1.getOrDefault(num, 0);
            int freq2 = map2.getOrDefault(num, 0);
            if(freq1 != freq2) {
                if((freq1+freq2)%2!=0) return -1;
                else cost += Math.abs(freq1-freq2)/2;
            }
        }
        return cost/2;
    }
}