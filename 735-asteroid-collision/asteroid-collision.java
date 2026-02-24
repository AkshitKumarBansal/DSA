class Solution {
    public int[] asteroidCollision(int[] arr) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            int curr = arr[i];
            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && curr < 0) {

                int top = st.peek();

                if (top < -curr) {       // stack asteroid smaller
                    st.pop();
                } 
                else if (top == -curr) { // equal
                    st.pop();
                    destroyed = true;
                    break;
                } 
                else {                   // stack asteroid bigger
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(curr);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}