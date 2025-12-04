class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0)+1);
        }
        int i = 0;
        int j = 0;
        int min = s.length()+1;
        int x = 0;
        int y = 0;
        int count = 0;
        while(j<s.length()) {
            if(map1.containsKey(s.charAt(j))) {
                map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0)+1);
                if(map2.get(s.charAt(j)).intValue()==map1.get(s.charAt(j)).intValue()) {
                    count++;
                }
            }
            j++;
            while(map1.size()==count) {
                if(min > j-i) {
                    min = Math.min(min, j-i);
                    x = i;
                }
                if(map1.containsKey(s.charAt(i))) {
                    if(map2.get(s.charAt(i)).intValue()==map1.get(s.charAt(i)).intValue()) {
                        count--;
                    }
                    map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0)-1);
                }
                i++;
            }
        }
        return (min == s.length()+1) ? "" : s.substring(x, x + min);
    }
}