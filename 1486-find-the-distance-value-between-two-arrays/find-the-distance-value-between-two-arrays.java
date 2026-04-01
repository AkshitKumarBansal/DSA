class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int n1 = arr1.length, n2 = arr2.length;
        for(int i=0;i<n1;i++) {
            boolean flag = true;
            for(int j=0;j<n2;j++) {
                if(Math.abs(arr2[j]-arr1[i])<=d) flag = false;
            }
            if(flag) count++;
        }
        return count;
    }
}