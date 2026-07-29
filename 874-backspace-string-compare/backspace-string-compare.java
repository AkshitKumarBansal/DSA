class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && c == '#') st.pop();
            else if(c == '#') continue;
            else st.push(c); 
        }
        int count = 0;
        for(int i=t.length()-1; i>=0; i--) {
            if(t.charAt(i) != '#' && count > 0) count--;
            else if(!st.isEmpty() && st.peek() == t.charAt(i)) st.pop();
            else if(t.charAt(i) == '#') count++;
            else return false;
        }
        return st.isEmpty();
    }
}