class Solution {
    public int arrangeCoins(int n) {
        if(n == 0) return 0;
        int count = 1;
        int j = 2;
        long i = 1;
        while(i<n){
            i += j;
            count++;
            j++;
        }
        if(i>n) return count-1;
        return count;
    }
}