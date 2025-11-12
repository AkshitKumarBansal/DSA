class Solution {
    public int convertTime(String current, String correct) {
        int count = 0;
        if((current.charAt(0)-'0')*10+(current.charAt(1)-'0') != (correct.charAt(0)-'0')*10+(correct.charAt(1)-'0')) {
            count = Math.abs(((current.charAt(0)-'0')*10+(current.charAt(1)-'0')) - ((correct.charAt(0)-'0')*10+(correct.charAt(1)-'0')));
        }
        int error = (((current.charAt(3)-'0') * 10) + (current.charAt(4)-'0')) - (((correct.charAt(3)-'0')*10) + (correct.charAt(4)-'0'));
        error = Math.abs(error);
        if((current.charAt(3)-'0')*10+(current.charAt(4)-'0') > (correct.charAt(3)-'0')*10+(correct.charAt(4)-'0')) {
            count -= 1;
            error = Math.abs(error-60);
            while(error > 0) {
                if((error/15) > 0 || (error/15 == 0 && error%15==0)) {
                    count += (error/15);
                    error %= 15;
                } else if(error/5 > 0 || (error/5 == 0 && error%5==0)) {
                    count += (error/5);
                    error %= 5;
                } else {
                    count += error/1;
                    error %= 1;
                }
            }
        }
        if((current.charAt(3)-'0')*10+(current.charAt(4)-'0') < (correct.charAt(3)-'0')*10+(correct.charAt(4)-'0')){
            while(error > 0) {
                if((error/15) > 0 || (error/15 == 0 && error%15==0)) {
                    count += (error/15);
                    error %= 15;
                } else if(error/5 > 0 || (error/5 == 0 && error%5==0)) {
                    count += (error/5);
                    error %= 5;
                } else {
                    count += error/1;
                    error %= 1;
                }
            }
        }
        return count;
    }
}