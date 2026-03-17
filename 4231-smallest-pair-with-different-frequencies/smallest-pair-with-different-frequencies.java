class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0)+1);
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int a = list.get(i);
                int b = list.get(j);

                if (map.get(a) != map.get(b)) {
                    return new int[]{a, b};
                }
            }
        }
        return new int[]{-1, -1};
    }
}