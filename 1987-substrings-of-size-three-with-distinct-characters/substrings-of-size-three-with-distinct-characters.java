class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3) return 0;
        int i = 0;
        int j = 1;
        int k = 2;
        int cnt = 0;
        while(k < s.length()) {
            if(s.charAt(i)!=s.charAt(j) && s.charAt(i)!=s.charAt(k) && s.charAt(j)!=s.charAt(k)) {
                cnt++;
            }
            i++;
            j++;
            k++;
        }
        return cnt;
    }
}