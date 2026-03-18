class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int b : bulbs) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}