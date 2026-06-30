class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().cnt++;
                if (st.peek().cnt == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(ch, 1));
            }
        }
        for (Pair p : st) {
            sb.append(String.valueOf(p.ch).repeat(p.cnt));
        }
        return sb.toString();
    }
}
class Pair {
    char ch;
    int cnt;
    Pair(char ch, int cnt) {
        this.ch = ch;
        this.cnt = cnt;
    }
}