class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        for(int[] x : trust) {
            arr[x[0]]--;
            arr[x[1]]++;
        }
        for(int i=1;i<=n;i++) {
            if(arr[i]==n-1) return i;
        }
        return -1;
    }
}