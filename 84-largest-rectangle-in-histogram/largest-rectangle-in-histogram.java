class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int area = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++) {
            int currH = (i==n) ? 0 : arr[i];
            while(!st.isEmpty() && currH < arr[st.peek()]) {
                int h = arr[st.pop()];
                int left = (st.isEmpty())?-1:st.peek();
                int right = i;
                int w = right-left-1;
                area = Math.max(area, h*w);
            }
            st.push(i);
        }
        return area;
    }
}