class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int MOD = 1_000_000_007;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[n];
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && arr[i]<arr[st.peek()]) st.pop();
            if(st.isEmpty()) ans[i] = i+1;
            else ans[i] = i-st.peek();
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();
            if(st.isEmpty()) ans[i] *= (n-i);
            else ans[i] *= (st.peek()-i);
            st.push(i);
        }
        for(int i=0;i<n;i++) {
            sum = (sum + (long)(arr[i]*ans[i])) % MOD;
        }
        return (int)(sum % MOD);
    }
}