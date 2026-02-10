class Solution {
    public int maxScore(String s) {
        int max = 0;
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') count++;
        }
        int count0 = 0;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)=='1') {
                count--;
            } else {
                count0++;
            }
            max = Math.max(max, count+count0);
        }
        return max;
    }
}