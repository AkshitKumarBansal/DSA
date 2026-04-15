class Solution {
    public String minWindow(String s, String t) {
        int i=0;
        int n = s.length();
        int min = Integer.MAX_VALUE;
        String res = "";
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
                    res = s.substring(i, j+1);
                }
                i++;
                flag = true;
                for(int k=0;k<26;k++) {
                    if(freq1[k]>0) flag = false;
                    if(freq2[k]>0) flag = false;
                }
            }
        }
        return res;
    }
    // private boolean check(String s, String t) {
    //     int freq1[] = new int[26];
    //     int freq2[] = new int[26];
    //     for(int i=0;i<t.length();i++) {
    //         char ch = t.charAt(i);
    //         if(ch>='a' && ch<='z') freq1[ch-'a']++;
    //         else freq2[ch-'A']++;
    //     }
    //     for(int i=0;i<s.length();i++) {
    //         char ch = s.charAt(i);
    //         if(ch>='a' && ch<='z') {
    //             if(freq1[ch-'a']!=0) {
    //                 freq1[s.charAt(i)-'a']--;
    //             }
    //         } else {
    //             if(freq2[ch-'A']!=0) {
    //                 freq2[s.charAt(i)-'A']--;
    //             }
    //         }
    //     }
    //     for(int i=0;i<26;i++) {
    //         if(freq1[i]>0) return false;
    //         if(freq2[i]>0) return false;
    //     }
    //     return true;
    // }
}