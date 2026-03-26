class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int x : target) map1.put(x, map1.getOrDefault(x, 0)+1);
        for(int x : arr) map2.put(x, map2.getOrDefault(x, 0)+1);
        for(Map.Entry<Integer, Integer> x : map1.entrySet()) {
            int key = x.getKey();
            int value = x.getValue();
            if(!map2.containsKey(key)) return false;
            else {
                if(map2.get(key)!=value) return false;
            }
        }
        return true;
    }
}