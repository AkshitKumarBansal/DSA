class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : paths) map.put(list.get(0), list.get(1));
        for(Map.Entry<String, String> x : map.entrySet()) {
            String key = x.getKey();
            String value = x.getValue();
            if(!map.containsKey(value)) return value;
        }
        return "";
    }
}