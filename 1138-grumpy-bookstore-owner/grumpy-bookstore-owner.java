class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for(int i=0;i<customers.length;i++) {
            if(grumpy[i]==0) {
                sum += customers[i];
            }
        }
        int sum1 = 0;
        for(int i=0;i<minutes;i++) {
            if(grumpy[i]==1) {
                sum1 += customers[i];
            }
        }
        int max = sum1;
        int i = 1;
        while(i+minutes<=grumpy.length) {
            if(grumpy[i-1]==1 && grumpy[i+minutes-1]==1) {
                sum1 = sum1 - customers[i-1] + customers[i+minutes-1];
            } else if(grumpy[i-1]==1) {
                sum1 -= customers[i-1];
            } else if(grumpy[i+minutes-1]==1) {
                sum1 += customers[i+minutes-1];
            }
            max = Math.max(sum1, max);
            i++;
        }
        return max+sum;
    }
}