class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0;
        int j = k;
        int sum = 0;
        for(int x=0;x<j;x++) {
            sum += arr[x];
        }
        int count = 0;
        if((sum/k) >= threshold) count++;
        i++;
        j++;
        while(j<=arr.length) {
            sum = sum - arr[i-1] + arr[j-1];
            if(sum/k >= threshold) count++;
            i++;
            j++;
        }
        return count;
    }
}