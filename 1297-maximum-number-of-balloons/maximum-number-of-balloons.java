class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] balloon = new int[26];
        balloon['b'-'a']++; balloon['a'-'a']++; balloon['l'-'a']+=2; balloon['o'-'a']+=2; balloon['n'-'a']++;
        int[] freq = new int[26];
        for(int i=0;i<text.length();i++) freq[text.charAt(i)-'a']++;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++) if(balloon[i]!=0) min = Math.min(min, freq[i]/balloon[i]);
        return min;
    }
}