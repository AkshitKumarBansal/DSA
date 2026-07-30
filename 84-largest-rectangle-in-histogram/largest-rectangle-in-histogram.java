class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) prev[i] = -1;
            else prev[i] = st.peek();
            st.push(i);
        }
        st.clear();
        int[] next = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) next[i] = n;
            else next[i] = st.peek();
            st.push(i);
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max((next[i]-prev[i]-1) * heights[i], max);
        }
        return max;
    }
}