class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int MOD = 1_000_000_007;
        int n = arr.length;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        long[] ans = new long[n];
        for(int i=0;i<n;i++) {
            while(!st1.isEmpty() && arr[i]<arr[st1.peek()]) st1.pop();
            if(st1.isEmpty()) ans[i] = i+1;
            else ans[i] = i-st1.peek();
            st1.push(i);
        }
        // for(int i=0;i<n;i++) {
        //     System.out.print(left[i]+"-");
        // }
        // System.out.println();
        for(int i=n-1;i>=0;i--) {
            while(!st2.isEmpty() && arr[i]<=arr[st2.peek()]) st2.pop();
            if(st2.isEmpty()) ans[i] *= (n-i);
            else ans[i] *= (st2.peek()-i);
            st2.push(i);
        }
        // for(int i=0;i<n;i++) {
        //     System.out.print(right[i]+"-");
        // }
        for(int i=0;i<n;i++) {
            sum = (sum + (long)(arr[i]*ans[i])) % MOD;
        }
        return (int)(sum % MOD);
    }
}