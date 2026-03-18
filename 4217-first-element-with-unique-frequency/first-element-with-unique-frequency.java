class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        Map<Integer, Integer> freq = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();
            // System.out.println(key+" "+value);
            freq.put(value, freq.getOrDefault(value, 0)+1);
        }
        for(int num : nums) {
            int f = map.get(num);
            if(freq.get(f) == 1) {
                return num;
            }
        }
        return -1;
    }
}