class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) map.put(i, map.getOrDefault(i, 0)+1);
        Map<Integer, Integer> map1 = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map1.put(entry.getValue(), map1.getOrDefault(entry.getValue(), 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(entry.getValue()>1) return false;
        }
        return true;
    }
}