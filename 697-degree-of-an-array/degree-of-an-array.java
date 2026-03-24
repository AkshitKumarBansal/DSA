class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int x = nums[i];
            int[] arr = map.get(x); // by reference not value
            if(arr == null) {
                map.put(x, new int[]{i, i, 1});
            } else {
                arr[1] = i;
                arr[2]++;
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