class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1) return heights[0];
        int i = 0;
        int j = 0;
        int area = 0;
        Stack<Integer> st = new Stack<>();
        st.push(i);
        while(j<=heights.length) {
            int h = (j == heights.length) ? 0 : heights[j];
            while(!st.isEmpty() && h<heights[st.peek()]) {
                int height = heights[st.pop()];
                int right = j;
                int left = st.isEmpty() ? -1 : st.peek();
                area = Math.max(area, height * (right - left - 1));
            }
            st.push(j);
            j++;
        }
        return area;
    }
}