class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr) map.put(a, map.getOrDefault(a, 0)+1);
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(set.contains(entry.getValue())) return false;
            set.add(entry.getValue());
        }
        return true;
    }
}