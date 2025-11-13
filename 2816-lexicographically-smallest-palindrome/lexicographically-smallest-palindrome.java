class Solution {
    public String makeSmallestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length()-1;
        while(l <= r) {
            if(sb.charAt(l) != sb.charAt(r)) {
                if(sb.charAt(l)<sb.charAt(r)) {
                    sb.setCharAt(r, sb.charAt(l)); 
                } else {
                    sb.setCharAt(l, sb.charAt(r));
                }
            }
            l++;
            r--;
        }
        return sb.toString();
    }
}