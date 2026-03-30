class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String s : words1) map1.put(s, map1.getOrDefault(s, 0)+1);
        for(String s : words2) map2.put(s, map2.getOrDefault(s, 0)+1);
        int count = 0;
        for(Map.Entry<String, Integer> x : map1.entrySet()) {
            String key = x.getKey();
            int value = x.getValue();
            if(value==1 && map2.getOrDefault(key, 0)==1) count++;
        }
        return count;
    }
}