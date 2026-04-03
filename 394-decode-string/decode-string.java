class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(index < s.length() && s.charAt(index)!=']') {
            int k = 0;
            if(!Character.isDigit(s.charAt(index))) {
                sb.append(s.charAt(index++));
            } else {
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k*10 + (int)(s.charAt(index++)-'0');
                }
                index++;
                String str = decodeString(s);
                index++;
                sb.append(str.repeat(k));
            }
        }
        return sb.toString();
    }
}