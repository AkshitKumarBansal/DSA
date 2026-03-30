class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        int x = -1;
        for(int i=0;i<26;i++) {
            if(freq[i]!=0 && x==-1) x = freq[i];
            if(freq[i]!=0 && x!=freq[i]) return false; 
        }
        return true;
    }
}