class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long sum = 0;
        long place = 1;
        while(n != 0) {
            int rem = n % 10;
            if(rem != 0) {
                num += rem * place;
                sum += rem;
                place *= 10;
            }
            n /= 10;
        }
        return sum * num;
    }
}