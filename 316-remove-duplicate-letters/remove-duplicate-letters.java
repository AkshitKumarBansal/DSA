class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(used[ch - 'a']) continue;
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && last[sb.charAt(sb.length() - 1) - 'a'] > i) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
            used[ch - 'a'] = true;
        }
        return sb.toString();
    }
}