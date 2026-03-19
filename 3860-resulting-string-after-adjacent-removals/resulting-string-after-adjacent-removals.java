class Solution {
    public String resultingString(String s) {
        StringBuilder st = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int n = st.length();
            if (n > 0 && (
                Math.abs(st.charAt(n - 1) - ch) == 1 ||
                (st.charAt(n - 1) == 'a' && ch == 'z') ||
                (st.charAt(n - 1) == 'z' && ch == 'a')
            )) {
                st.deleteCharAt(n - 1);
            } else {
                st.append(ch);
            }
        }
        return st.toString();
    }
}