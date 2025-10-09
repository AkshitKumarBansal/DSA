class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // int medM = (m%2==1) ? ((m%2)+1) : (m);
        // int medN = num2[0];
        // if() medM[m%2+1];
        // if(n%2==)
        int[] sort = new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                sort[k++] = nums1[i++];
            }
            else{
                sort[k++] = nums2[j++];
            }
        }
        while (i < m) {
            sort[k++] = nums1[i++];
        }
        while (j < n) {
            sort[k++] = nums2[j++];
        }
        int mid = (m+n)/2;
        if((m + n) % 2 == 1){
            return sort[mid];
        }
        else{
            return (sort[mid - 1] + sort[mid]) / 2.0;
        }
    }
}