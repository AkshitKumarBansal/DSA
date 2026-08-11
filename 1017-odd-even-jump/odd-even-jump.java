class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;

        int maxVal = Integer.MIN_VALUE;
        for(int i : arr) maxVal = Math.max(i, maxVal);

        int[] values = new int[maxVal + 1];
        Arrays.fill(values, -1);

        int[] next = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            next[i] = values[val];
            values[val] = i;
        }

        int[] sortedArr = new int[n];
        int j = 0;
        for(int i = 0; i <= maxVal; i++) {
            int val = values[i];
            while(val != -1) {
                sortedArr[j++] = val;
                val = next[val];
            }
        }
        
        Stack<Integer> stack = new Stack<>();

        int[] nextLargest = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && sortedArr[i] > stack.peek()) stack.pop();
            if(stack.isEmpty()) nextLargest[sortedArr[i]] = -1;
            else nextLargest[sortedArr[i]] = stack.peek();
            stack.push(sortedArr[i]);
        }

        while(!stack.isEmpty()) stack.pop();

        int[] sortedDesc = new int[n];
        j = 0;
        for(int i = maxVal; i >= 0; i--) {
            int val = values[i];
            while(val != -1) {
                sortedDesc[j++] = val;
                val = next[val];
            }
        }

        int[] nextSmallest = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && sortedDesc[i] > stack.peek()) stack.pop();
            if(stack.isEmpty()) nextSmallest[sortedDesc[i]] = -1;
            else nextSmallest[sortedDesc[i]] = stack.peek();
            stack.push(sortedDesc[i]);
        }

        int count = 1;
        boolean[][] dp = new boolean[n][2];
        dp[n-1][0] = true;
        dp[n-1][1] = true;
        for(int i = n - 2; i >= 0; i--) {
            if(nextLargest[i] != -1) {
                dp[i][0] = dp[nextLargest[i]][1];
            }
            if(nextSmallest[i] != -1) {
                dp[i][1] = dp[nextSmallest[i]][0];
            }
            if(dp[i][0]) count++;
        }

        return count;
    }
}