class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)-'a']++;
        int var = s.length();
        StringBuilder sb = new StringBuilder();
        while(sb.length()<var) {
            for(int i=0;i<26;i++) {
                if(freq[i]>0) {
                    sb.append((char)(i+'a'));
                    freq[i]--;
                }
            }
            for(int i=25;i>=0;i--) {
                if(freq[i]>0) {
                    sb.append((char)(i+'a'));
                    freq[i]--;
                }
            }
        }
        return sb.toString();
    }
}