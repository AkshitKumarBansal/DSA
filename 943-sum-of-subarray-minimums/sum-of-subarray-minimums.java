class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int MOD = 1_000_000_007;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++) {
            int curr = (i == n) ? 0 : arr[i];
            while(!st.isEmpty() && curr<arr[st.peek()]) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum = (sum + arr[mid] * leftCount * rightCount) % MOD;
            }
            st.push(i);
        }
        return (int)(sum % MOD);
    }
}