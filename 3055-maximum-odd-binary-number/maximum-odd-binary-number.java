class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt1 = 0;
        int cnt0 = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') {
                cnt1++;
            } else {
                cnt0++;
            }
        }
        if(cnt1 > 1) {
            for(int i=0;i<cnt1-1;i++) {
                sb.append(1);
            }
        }
        for(int i=0;i<cnt0;i++) {
            sb.append(0);
        }
        if(cnt1 != 0) sb.append(1);
        return sb.toString();
    }
}