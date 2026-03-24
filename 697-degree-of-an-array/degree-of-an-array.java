class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int x = nums[i];
            if(!map.containsKey(x)) {
                map.put(x, new int[]{i, i, 1});
            } else {
                int freq = map.get(x)[2];
                map.get(x)[2] = freq+1;
                map.get(x)[1] = i;
            }
        }
        int max = 0;
        for(int[] x : map.values()) max = Math.max(x[2], max);
        int min = n;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] x = entry.getValue();
            if(max == x[2]) {
                min = Math.min(x[1]-x[0]+1, min);
            }
        }
        return min;
    }
}