class Solution {
    int count = 0;
    public int distributeCandies(int n, int limit) {
        if(limit*3 < n) return 0;
        solve(n, 0, limit);
        return count;
    }
    private void solve(int n, int child, int limit) {
        if(child == 3) {
            if(n==0) {
                count++;
            }
            return;
        }
        for(int i=0;i<=Math.min(n, limit);i++) {
            solve(n-i, child+1, limit);
        }
    }
}