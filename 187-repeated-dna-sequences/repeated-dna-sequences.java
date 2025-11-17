class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 10;
        Map<String, Integer> map = new HashMap<>();
        while(j<=s.length()) {
            map.put(s.substring(i, j), map.getOrDefault(s.substring(i, j), 0)+1);
            i++;
            j++;
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()>1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}