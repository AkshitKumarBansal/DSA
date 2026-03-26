class Solution {
    public int secondHighest(String s) {
        int max = -1, smax = -1;
        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                int x = s.charAt(i) - '0';
                if(max == -1) max = x;
                else {
                    if(max < x) {
                        smax = max;
                        max = x;
                    } else {
                        if(max != x) smax = Math.max(smax, x);
                    }
                }
            }
        }
        return smax;
    }
}