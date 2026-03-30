class Solution {
    public String longestNiceSubstring(String s) {
        int start = -1, end = -1, max = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length();j++) {
                if(check(s.substring(i, j+1))) {
                    System.out.println("Yes");
                    if(max < j-i+1) {
                        max = j-i+1;
                        System.out.println("Max");
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return (max==0) ? "" : s.substring(start, end+1);
    }
    private boolean check(String s) {
        boolean[] freq1 = new boolean[26];
        boolean[] freq2 = new boolean[26];
        for(char ch : s.toCharArray()) {
            if(ch>='a' && ch<='z') freq1[ch-'a'] = true;
            else freq2[ch-'A'] = true;
        }
        for(int i=0;i<26;i++) {
            if(freq1[i]!=freq2[i]) return false;
        }
        return true;
    }
}