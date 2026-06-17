class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        return solve(sb);
    }
    private boolean solve(StringBuilder sb) {
        if(sb.length()==2) {
            if(sb.charAt(0)==sb.charAt(1)) return true;
            return false;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<sb.length()-1;i++) {
            int num = ((sb.charAt(i)-'0')+(sb.charAt(i+1)-'0'))%10;
            str.append(num);
        }
        return solve(str);
    }
}