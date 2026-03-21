class Solution {
    public void duplicateZeros(int[] arr) {
        int[] ans = new int[arr.length];
        int j = 0;
        for(int i=0;i<arr.length && j<arr.length;i++) {
            if(arr[i]!=0) ans[j++] = arr[i];
            else {
                ans[j++] = 0;
                if(j<arr.length) {
                    ans[j++] = 0;
                }
            }
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = ans[i];
        }
        // return ans;
    }
}