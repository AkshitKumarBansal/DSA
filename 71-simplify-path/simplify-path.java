class Solution {
    public String simplifyPath(String path) {
        Stack<Character> st = new Stack<>();
        int dot = 0;
        for(char c : path.toCharArray()) {
            if(c == '.') {
                if(!st.isEmpty() && st.peek() == '/' && c == '.' && dot == 0) dot++;
                else if(!st.isEmpty() && st.peek() == '.' && c == '.' && dot > 0) dot++;
            }
            if(!st.isEmpty() && st.peek() == '/' && c == '/') continue;
            else if(!st.isEmpty() && st.peek() == '.' && c == '/') {
                if(dot == 1) {
                    st.pop();
                    st.pop();
                }
                if(dot == 2) {
                    int count = 1;
                    while(!st.isEmpty()) {
                        if(st.peek() == '/' && count == 0) {
                            st.pop();
                            break;
                        }
                        else if(st.peek() == '/') count--;
                        st.pop();
                    }
                }
                st.push(c);
                dot = 0;
            } else {
                st.push(c);
            }
        }
        if(!st.isEmpty() && st.peek() == '.' && dot == 1) st.pop();
        if(!st.isEmpty() && st.peek() == '.' && dot == 2) {
            int count = 1;
            while(!st.isEmpty()) {
                if(st.peek() == '/' && count == 0) {
                    break;
                }
                else if(st.peek() == '/') count--;
                st.pop();
            }
        }
        if(st.size() > 2 && st.peek() == '/') st.pop();
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        if(sb.length() == 0) sb.append('/');
        return sb.reverse().toString();
    }
}