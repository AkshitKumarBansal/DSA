class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k*10 + (int)(ch-'0');
            } else if(ch == '[') {
                num.push(k);
                str.push(sb);
                sb = new StringBuilder();
                k = 0;
            } else if(ch == ']') {
                int count = num.pop();
                StringBuilder prev = str.pop();
                for(int i=0;i<count;i++) {
                    prev.append(sb);
                } 
                sb = prev;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}