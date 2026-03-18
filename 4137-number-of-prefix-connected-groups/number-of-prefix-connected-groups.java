class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(word.length()<k) continue;
            String sub = word.substring(0, k);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        int ans = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value>1) ans++;
        }
        return ans;
    }
}