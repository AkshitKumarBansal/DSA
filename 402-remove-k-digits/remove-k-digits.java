class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++) {
            boolean flag = false;
            while(!st.isEmpty() && k>0 && num.charAt(i)<st.peek()) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder number = new StringBuilder();
        while(!st.isEmpty()) {
            number.append(st.pop()); 
        }
        number.reverse();
        while(number.length() > 0 && number.charAt(0) == '0') {
            number.deleteCharAt(0);
        }
        if(number.length() == 0) {
            return "0";
        }
        return number.toString();
    }
}