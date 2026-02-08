class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");
        if(pattern.length()!=arr.length) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<pattern.length();i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(arr[i])) return false;
            } else {
                if(set.contains(arr[i])) return false;
                map.put(pattern.charAt(i), arr[i]);
                set.add(arr[i]);
            }
        }
        return true;
    }
}