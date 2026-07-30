class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]++;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]--;
            if(visited[ch]) continue;
            while(!st.isEmpty() && st.peek() >= ch && count[st.peek()] > 0) {
                visited[st.pop()] = false;
            }
            st.push(ch);
            visited[ch] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append((char)(st.pop() + 'a'));
        return sb.reverse().toString();
    }
}