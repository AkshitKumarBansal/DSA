class Solution {
    public String minWindow(String s, String t) {
        int i=0;
        int n = s.length();
        int start = 0;
        int min = Integer.MAX_VALUE;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            if(ch>='a' && ch<='z') freq1[ch-'a']++;
            else freq2[ch-'A']++;
        }
        for(int j=0;j<n;j++) {
            char ch = s.charAt(j);
            if(ch>='a' && ch<='z') {
                freq1[ch-'a']--;
            } else {
                freq2[ch-'A']--;
            }
            boolean flag = true;
            for(int k=0;k<26;k++) {
                if(freq1[k]>0) flag = false;
                if(freq2[k]>0) flag = false;
            }
            while(flag) {
                char c = s.charAt(i);
                if(c>='a' && c<='z') {
                    freq1[c-'a']++;
                } else {
                    freq2[c-'A']++;
                }
                if(min>(j-i+1)) {
                    min = j-i+1;
                    start = i;
                }
                i++;
                flag = true;
                for(int k=0;k<26;k++) {
                    if(freq1[k]>0) flag = false;
                    if(freq2[k]>0) flag = false;
                }
            }
        }
        return (min==Integer.MAX_VALUE) ? "" : s.substring(start, start+min);
    }
}