class Solution {
    public int balancedStringSplit(String s) {
        int countR = 0;
        int countL = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R') countR++;
            if(s.charAt(i)=='L') countL++;
            if(countR != 0 && countR == countL) {
                count++;
                countR = 0;
                countL = 0;
            }
        }
        return count;
    }
}