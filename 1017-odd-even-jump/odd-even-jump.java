import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;

        // 1. Find the maximum value to determine our memory constraints
        int maxVal = Integer.MIN_VALUE;
        for (int i : arr) {
            maxVal = Math.max(maxVal, i);
        }

        // 2. The Hybrid Router
        // 10,000,000 ints take ~40MB of RAM, which is very safe.
        // If maxVal is under this threshold, use the O(N) Counting Sort.
        // Otherwise, fall back to O(N log N) TreeMap to prevent OutOfMemory errors.
        if (maxVal <= 10_000_000) {
            return solveWithCountingSort(arr, maxVal, n);
        } else {
            return solveWithTreeMap(arr, n);
        }
    }

    // =========================================================
    // APPROACH 1: Extremely Fast O(N) Counting Sort + Stacks
    // =========================================================
    private int solveWithCountingSort(int[] arr, int maxVal, int n) {
        // --- 1. Setup Buckets for O(N) Stable Sort ---
        int[] values = new int[maxVal + 1];
        Arrays.fill(values, -1);
        int[] next = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            next[i] = values[val];
            values[val] = i;
        }

        // --- 2. Build Ascending Sorted Indices ---
        int[] sortedArr = new int[n];
        int j = 0;
        for (int i = 0; i <= maxVal; i++) {
            int val = values[i];
            while (val != -1) {
                sortedArr[j++] = val;
                val = next[val];
            }
        }
        
        // --- 3. Find nextLargest (Odd Jumps) ---
        Stack<Integer> stack = new Stack<>();
        int[] nextLargest = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && sortedArr[i] > stack.peek()) stack.pop();
            if (stack.isEmpty()) nextLargest[sortedArr[i]] = -1;
            else nextLargest[sortedArr[i]] = stack.peek();
            stack.push(sortedArr[i]);
        }

        stack.clear();

        // --- 4. Build Descending Sorted Indices ---
        int[] sortedDesc = new int[n];
        j = 0;
        for (int i = maxVal; i >= 0; i--) {
            int val = values[i];
            while (val != -1) {
                sortedDesc[j++] = val;
                val = next[val];
            }
        }
        
        // --- 5. Find nextSmallest (Even Jumps) ---
        int[] nextSmallest = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && sortedDesc[i] > stack.peek()) stack.pop();
            if (stack.isEmpty()) nextSmallest[sortedDesc[i]] = -1;
            else nextSmallest[sortedDesc[i]] = stack.peek();
            stack.push(sortedDesc[i]);
        }

        return calculateDP(nextLargest, nextSmallest, n);
    }

    // =========================================================
    // APPROACH 2: Memory-Safe O(N log N) TreeMap Fallback
    // =========================================================
    private int solveWithTreeMap(int[] arr, int n) {
        int[] nextLargest = new int[n];
        int[] nextSmallest = new int[n];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            
            // Ceiling finds the smallest key >= val
            Integer ceil = map.ceilingKey(val);
            nextLargest[i] = (ceil != null) ? map.get(ceil) : -1;
            
            // Floor finds the largest key <= val
            Integer floor = map.floorKey(val);
            nextSmallest[i] = (floor != null) ? map.get(floor) : -1;
            
            // Put stores the value and index. Since we loop backwards, 
            // duplicates naturally update to the smallest index.
            map.put(val, i);
        }
        
        return calculateDP(nextLargest, nextSmallest, n);
    }

    // =========================================================
    // SHARED LOGIC: The 2D DP Array
    // =========================================================
    private int calculateDP(int[] nextLargest, int[] nextSmallest, int n) {
        int count = 1; // Last element is always a valid starting point
        boolean[][] dp = new boolean[n][2];
        
        // Base case: reaching the last index is a success
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        
        for (int i = n - 2; i >= 0; i--) {
            // Odd jump (dp[i][0]) looks at the Even state of the target
            if (nextLargest[i] != -1) {
                dp[i][0] = dp[nextLargest[i]][1];
            }
            
            // Even jump (dp[i][1]) looks at the Odd state of the target
            if (nextSmallest[i] != -1) {
                dp[i][1] = dp[nextSmallest[i]][0];
            }
            
            // Jump 1 is always Odd, so count if dp[i][0] is true
            if (dp[i][0]) {
                count++;
            }
        }
        
        return count;
    }
}