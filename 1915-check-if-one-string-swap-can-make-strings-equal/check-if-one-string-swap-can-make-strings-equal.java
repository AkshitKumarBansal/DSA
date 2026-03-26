class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int[] freq = new int[26];
        int count = 0;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) count++;
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        if(count != 2 && count != 0) return false;
        for(int i=0;i<26;i++) if(freq[i]!=0) return false;
        return true;
    }
}