class Solution {
    public boolean checkRecord(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                cnt1++;
            }
            if (i + 2 < s.length() && s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') {
                cnt2++;
            }
        }
        if(cnt1>1 || cnt2>0){
            return false;
        }
        return true;
    }
}