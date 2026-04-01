class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Arrays.sort(arr2);
        int n1 = arr1.length, n2 = arr2.length;
        for(int i=0;i<n1;i++) {
            boolean flag = true;
            int l = 0, r = n2-1;
            while(l<=r) {
                int mid = (r+l)/2;
                if(Math.abs(arr2[mid]-arr1[i])<=d) {
                    flag = false;
                    break;
                } else if(arr2[mid]<arr1[i]) l = mid+1;
                else r = mid-1;
            }
            if(flag) count++;
        }
        return count;
    }
}