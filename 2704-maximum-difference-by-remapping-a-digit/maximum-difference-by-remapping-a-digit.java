class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int digit = String.valueOf(num).length();
        int rem = num / (int)Math.pow(10, (digit-1));
        int min = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)-'0' == rem) {
                min = 0 + (min*10);
            } else {
                min = (s.charAt(i)-'0') + (min*10);
            }
        }
        int number = num % (int)Math.pow(10, digit-1);
        while(rem == 9) {
            digit--;
            if(digit == 0) {
                rem = 0;
                break;
            }
            rem = number / (int)Math.pow(10, digit-1);
            number = number % (int)Math.pow(10, digit-1);
        }
        int max = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)-'0' == rem) {
                max = 9 + (max*10);
            } else {
                max = (s.charAt(i)-'0') + (max*10);
            }
        }
        return max-min;
    }
}