class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] freqS1 = new int[26];
        int[] freqSub2 = new int[26];
        for(int i=0;i<s1.length();i++){
            freqS1[s1.charAt(i)-'a']++;
            freqSub2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freqS1, freqSub2)) return true;
        int x=0;
        int y=s1.length();
        while(y<s2.length()){
            freqSub2[s2.charAt(x)-'a']--;
            freqSub2[s2.charAt(y)-'a']++;
            if(Arrays.equals(freqS1, freqSub2)) return true;
            x++;
            y++;
        }
        return false;
    }
}