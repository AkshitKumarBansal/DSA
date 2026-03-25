class Solution {
    public int findLucky(int[] arr) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) map.put(x, map.getOrDefault(x, 0)+1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(key == value) max = Math.max(max, key);
        }
        return max;
    }
}