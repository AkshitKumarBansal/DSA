class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int x : arr) {
            if (st.isEmpty() || x >= st.peek()) {
                st.push(x);
            }
            else {
                int max = st.pop();
                while (!st.isEmpty() && st.peek() > x) {
                    st.pop();
                }
                st.push(max);
            }
        }
        return st.size();
    }
}