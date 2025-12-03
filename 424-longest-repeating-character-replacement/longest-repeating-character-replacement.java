class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j<s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            if((j-i+1)-Collections.max(map.values())<=k) {
                j++;
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)-1);
                if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
                i++;
                j++;
            }
            max = Math.max(max, j-i+1);
        }
        return max-1;
    }
}