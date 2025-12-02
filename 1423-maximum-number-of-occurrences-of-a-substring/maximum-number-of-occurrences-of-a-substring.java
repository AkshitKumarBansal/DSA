class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> mapS = new HashMap<>();
        for(int i=0;i<minSize;i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(map.size()<=maxLetters) {
            mapS.put(s.substring(0, minSize), mapS.getOrDefault(s.substring(0, minSize), 0) + 1);
        }
        int i = 1;
        int j = minSize+1;
        while(j<=s.length()) {
            map.put(s.charAt(i-1), map.getOrDefault(s.charAt(i-1), 0) - 1);
            if(map.get(s.charAt(i-1))==0) map.remove(s.charAt(i-1));
            map.put(s.charAt(j-1), map.getOrDefault(s.charAt(j-1), 0) + 1);
            if(map.size()<=maxLetters) {
                mapS.put(s.substring(i, j), mapS.getOrDefault(s.substring(i, j), 0) + 1);
            }
            i++;
            j++;
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : mapS.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}