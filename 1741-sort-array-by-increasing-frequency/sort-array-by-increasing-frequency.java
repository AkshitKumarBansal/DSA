class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : nums) freq.put(x, freq.getOrDefault(x, 0)+1);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(Map.Entry<Integer, Integer> x : freq.entrySet()) {
            int key = x.getKey();
            int value = x.getValue();
            if(map.containsKey(value)) map.get(value).add(key);
            else {
                map.put(value, new ArrayList<>());
                map.get(value).add(key);
            }
        }
        int k = 0;
        for(Map.Entry<Integer, List<Integer>> x : map.entrySet()) {
            int key = x.getKey();
            List<Integer> list = x.getValue();
            Collections.sort(list, Collections.reverseOrder());
            for(int i=0;i<list.size();i++) {
                for(int j=0;j<key;j++) {
                    ans[k++] = list.get(i);
                }
            }
        }
        return ans;
    }
}