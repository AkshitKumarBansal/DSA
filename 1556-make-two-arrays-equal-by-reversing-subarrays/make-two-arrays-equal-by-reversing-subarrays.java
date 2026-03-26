class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : target) map.put(x, map.getOrDefault(x, 0)+1);
        for (int x : arr) {
            if (!map.containsKey(x) || map.get(x) == 0) return false;
            map.put(x, map.get(x) - 1);
        }
        return true;
    }
}