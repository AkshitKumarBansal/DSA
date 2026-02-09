class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String s = s1 + " " + s2;
        String[] arr = s.split("\\s+");
        for(String word : arr){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        String[] ans = new String[arr.length];
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()==1) {
                ans[i++] = entry.getKey();
            }
        }
        return Arrays.copyOfRange(ans, 0, i);
    }
}