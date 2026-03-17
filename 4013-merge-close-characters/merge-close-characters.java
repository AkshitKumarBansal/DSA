class Solution {
    public String mergeCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), sb.length());
                sb.append(s.charAt(i));
            } else {
                if(sb.length()-map.get(s.charAt(i))>k) {
                    sb.append(s.charAt(i));
                    map.put(s.charAt(i), sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}