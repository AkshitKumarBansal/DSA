class Solution {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5;i++) {
            if(i == 0 && time.charAt(i)=='?' && (time.charAt(1)>'3' && time.charAt(1)<='9')){
                sb.append(1);
            } else if(i == 0 && time.charAt(i)=='?'){
                sb.append(2);
            } else if(i == 1 && time.charAt(i)=='?' && time.charAt(0)<'2') {
                sb.append(9);
            } else if(i == 1 && time.charAt(i)=='?' && (time.charAt(0)=='2' || time.charAt(0)=='?')) {
                sb.append(3);
            } else if(i == 3 && time.charAt(i)=='?') {
                sb.append(5);
            } else if(i == 4 && time.charAt(i)=='?') {
                sb.append(9);
            } else {
                sb.append(time.charAt(i));
            }
        }
        return sb.toString();
    }
}