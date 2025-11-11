class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
        }
        int count = 0;
        if(sum%3 != 0) {
            return false;
        }
        int target = sum/3;
        int sum1 = 0;
        for(int i=0;i<arr.length;i++) {
            sum1 += arr[i];
            if(sum1 == target) {
                count++;
                sum1 = 0;
            }
        }
        return count>=3;
    }
}