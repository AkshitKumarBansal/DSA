class Solution {
    public int maxVowels(String s, int k) {
        int i = 1;
        int j = k+1;
        int cnt = 0;
        for(int x=0;x<k;x++) {
            if(s.charAt(x)=='a' || s.charAt(x)=='e' || s.charAt(x)=='i' || s.charAt(x)=='o' || s.charAt(x)=='u') {
                cnt++;
            }
        }
        int len = cnt;
        while(j <= s.length()) {
            if((s.charAt(i-1)=='a' || s.charAt(i-1)=='e' || s.charAt(i-1)=='i' || s.charAt(i-1)=='o' || s.charAt(i-1)=='u') && (s.charAt(j-1)!='a' && s.charAt(j-1)!='e' && s.charAt(j-1)!='i' && s.charAt(j-1)!='o' && s.charAt(j-1)!='u')) {
                cnt--;
            } else if((s.charAt(i-1)!='a' && s.charAt(i-1)!='e' && s.charAt(i-1)!='i' && s.charAt(i-1)!='o' && s.charAt(i-1)!='u') && (s.charAt(j-1)=='a' || s.charAt(j-1)=='e' || s.charAt(j-1)=='i' || s.charAt(j-1)=='o' || s.charAt(j-1)=='u')) {
                cnt++;
            }
            len = Math.max(len, cnt);
            i++;
            j++;
        }
        return len;
    }
}