class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = num.length();
        for(int i = 0; i < n; i++) {
            int c = num.charAt(i) - '0';
            while(!st.isEmpty() && st.peek() > c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        int i = 0;
        while(i < sb.length()) {
            if(sb.charAt(i) != '0') break;
            sb.deleteCharAt(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}