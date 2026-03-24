class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        int[] freq = new int[26];
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)!=goal.charAt(i)) count++;
            freq[s.charAt(i)-'a']++;
        }
        int max = 0;
        for(int i=0;i<26;i++) {
            max = Math.max(max, freq[i]);
        }
        for(int i=0;i<n;i++) {
            freq[goal.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++) {
            if(freq[i]!=0) return false;
        }
        if((count==0 && max >= 2)) return true;
        return (count != 2) ? false : true; 
    }
}