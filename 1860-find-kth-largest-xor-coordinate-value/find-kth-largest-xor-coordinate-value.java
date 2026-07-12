class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pref = new int[m][n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                pref[i][j] = matrix[i][j];

                if (i > 0)
                    pref[i][j] ^= pref[i - 1][j];

                if (j > 0)
                    pref[i][j] ^= pref[i][j - 1];

                if (i > 0 && j > 0)
                    pref[i][j] ^= pref[i - 1][j - 1];

                pq.offer(pref[i][j]);

                if (pq.size() > k)
                    pq.poll();
            }
        }

        return pq.peek();
    }
}