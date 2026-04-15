class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        for(int j=0;j<n;j++) {
            arr[0][j] = (int)matrix[0][j]-'0';
        }
        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]!='0') {
                    arr[i][j] = arr[i-1][j]+1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=0;i<m;i++) {
            int area = solve(arr[i]);
            max = Math.max(max, area);
        }
        return max;
    }
    public int solve(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] prev = new int[n];
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) prev[i] = -1;
            else prev[i] = st.peek();
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        int[] next = new int[n];
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) next[i] = n;
            else next[i] = st.peek();
            st.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++) {
            int area = arr[i]*(next[i]-prev[i]-1);
            max = Math.max(area, max);
        }
        return max;
    }
}