class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String s : arr) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int i = 1;
        for(Map.Entry<String, Integer> x : map.entrySet()) {
            String key = x.getKey();
            int value = x.getValue();
            if(value==1 && i==k) return key;
            if(value==1) i++;
        }
        return "";
    }
}