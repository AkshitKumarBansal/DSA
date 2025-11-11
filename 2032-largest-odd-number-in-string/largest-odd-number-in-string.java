class Solution {
    public String largestOddNumber(String num) {
        // if((num.charAt(num.length()-1)-'0')%2!=0) return num;
        int max = -1;
        for(int i=0;i<num.length();i++) {
            if((num.charAt(i)-'0')%2!=0) {
                max = i;
            }
        }
        return (max==-1) ? "" : num.substring(0, max+1);
    }
}