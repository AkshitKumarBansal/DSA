class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        if(k > numOnes) {
            sum += numOnes;
            k -= numOnes;
        } else if(k <= numOnes) {
            return k;
        }
        if(k > numZeros) {
            k -= numZeros;
        } else if(k <= numZeros) {
            return sum;
        }
        if(k > numNegOnes) {
            sum -= numNegOnes;
            k -= numNegOnes;
        } else if(k <= numNegOnes) {
            sum -= k;
            k -= numNegOnes;
        }
        return sum;
    }
}